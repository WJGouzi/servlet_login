package com.wj.login.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Project : servlet_login
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 19:49
 **/
@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html;charset=utf-8");
        //response.getWriter().write("登录失败，请核对账号或密码");
        // 如下是返会的json数据
        response.setContentType("text/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String str ="{\"message\":\"登录失败，请核对账号或密码\"}";
        PrintWriter writer = response.getWriter();
        writer.print(str);
        writer.flush();
        writer.close();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
