package com.wj.login.web.servlet;

import com.wj.login.dao.StudentBasicInfoDAO;
import com.wj.login.domain.StudentBasicInfoBean;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Project : servlet_login
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/17 22:40
 * 和login.jsp继续配合
 **/
@WebServlet("/newLoginServlet")
public class NewLoginServlet extends HttpServlet {
    private StudentBasicInfoDAO studentBasicInfoDAO = new StudentBasicInfoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        // 拿到获取的session
        HttpSession session = request.getSession();
        String checkCodeNumber = (String) session.getAttribute("checkCodeNumber");
        // 拿到验证码后就立即让失效
        session.removeAttribute("checkCodeNumber");
        System.out.println(checkCodeNumber + "----" + checkcode);
        if (checkCodeNumber != null && checkCodeNumber.equalsIgnoreCase(checkcode)) {
            // 正确的验证码
            StudentBasicInfoBean userInfo = this.getUserInfo(username, password);
            if (userInfo != null) {
                // 重定向到success.jsp
                session.setAttribute("userName", username);
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                request.setAttribute("loginError", "账号名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else  {
            // 错误的验证码
            request.setAttribute("loginCheckCodeError", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * 在数据库进行查询数据
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return 返回用户的信息
     */
    public StudentBasicInfoBean getUserInfo(String username, String password) {
        // 2.使用BeanUtils方法设置javaBean
        StudentBasicInfoBean studentBasicInfoBean = new StudentBasicInfoBean();
        studentBasicInfoBean.setUsername(username);
        studentBasicInfoBean.setPassword(password);
        StudentBasicInfoBean infoBean = studentBasicInfoDAO.login(studentBasicInfoBean);
        return infoBean;
    }

}
