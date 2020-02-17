package com.wj.login.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Project : servlet_login
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/13 21:16
 **/
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0, width, height);
        graphics.setColor(Color.CYAN);
        graphics.drawRect(0, 0 , width - 1, height - 1);


        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] chars = new char[4];
        Random random = new Random();
        for (int i = 1; i <= 4; i ++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            graphics.setFont(new Font(c + "", 0, 25));
            graphics.drawString(c + "", width / 5 * i , (int) (height * 0.5));
            chars[i - 1] = c;
        }

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 设置最新的session
        HttpSession session = request.getSession();
        String number = String.valueOf(chars);
        session.setAttribute("checkCodeNumber", number);
        System.out.println(number + ": char[] is :"+ chars);
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
