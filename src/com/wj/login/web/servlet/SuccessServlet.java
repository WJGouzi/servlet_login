package com.wj.login.web.servlet;

import com.wj.login.domain.StudentBasicInfoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project : servlet_login
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 19:49
 **/
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // cookie的获取(数据进行了共享)
        String info = (String) request.getAttribute("info");
        String time = (String) request.getAttribute("time");
        StudentBasicInfoBean student = (StudentBasicInfoBean) request.getAttribute("student");
        if (student != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录登录成功");
            response.getWriter().write("<br>");
            String formatTime = null;
            if (time != null) {
                Long time1 = new Long(time);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                formatTime = simpleDateFormat.format(new Date(time1));
            }
            response.getWriter().write(info + (time != null ?  "<br>您上次访问的时间为:" + formatTime : ""));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
