package com.wj.login.web.servlet;

import com.wj.login.dao.StudentBasicInfoDAO;
import com.wj.login.domain.StudentBasicInfoBean;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @Project : servlet_login
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 17:16
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private StudentBasicInfoDAO studentBasicInfoDAO = new StudentBasicInfoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("加油");

        // 对于Cookie的处理
        Cookie[] cookies = request.getCookies();
        String info = null;
        String time = null;
        String currentTime = "" + System.currentTimeMillis();

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("lastTime")) {
                    info = "欢迎您回来";
                    time = cookie.getValue();
                    cookie.setValue(currentTime);
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    response.addCookie(cookie);
                }
                break;
            }
        } else {
            info = "您好，欢迎您首次访问";
            // 设置cookie
            Cookie lastTimeCookie = new Cookie("lastTime", currentTime);
            lastTimeCookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(lastTimeCookie);
        }

        // 1.常规操作
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        //StudentBasicInfoBean studentBasicInfoBean = new StudentBasicInfoBean();
        //studentBasicInfoBean.setLoginName(username);
        //studentBasicInfoBean.setPassword(password);

        // 2.使用BeanUtils方法设置javaBean
        Map<String, String[]> parameterMap = request.getParameterMap();
        StudentBasicInfoBean studentBasicInfoBean = new StudentBasicInfoBean();
        try {
            BeanUtils.populate(studentBasicInfoBean, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        request.setAttribute("info", info);
        request.setAttribute("time", time);
        StudentBasicInfoBean infoBean = studentBasicInfoDAO.login(studentBasicInfoBean);
        if (infoBean == null) {
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            request.setAttribute("student", infoBean);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
