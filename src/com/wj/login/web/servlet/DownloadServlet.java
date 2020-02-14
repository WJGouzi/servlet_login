package com.wj.login.web.servlet;

import com.wj.login.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Project : servlet_login
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/14 20:46
 **/
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取文件名字
        String filename = request.getParameter("filename");
        // 2.获取文件的真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/resources/" + filename);
        FileInputStream fis = new FileInputStream(realPath);
        // 设置响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        // 将文件以附件的形式进行下载
        String agent = request.getHeader("user-agent");
        filename = DownloadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition", "attachment;filename="+filename);
        // 将文件输入流写入到响应消息的输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int index = 0;
        while ((index = fis.read(buffer)) != -1) {
            sos.write(buffer, 0, index);
        }
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
