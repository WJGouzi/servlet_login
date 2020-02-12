package com.wj.login.web.servlet;

import com.wj.login.domain.StudentBasicInfoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        StudentBasicInfoBean student = (StudentBasicInfoBean) request.getAttribute("student");
        if (student != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录登录成功");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
