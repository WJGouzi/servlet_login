package com.wj.login.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Project : servlet_login
 * @Package : com.wj.login.utils
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/14 22:04
 **/
public class DownloadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+" , " ");
        } else if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else  {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
