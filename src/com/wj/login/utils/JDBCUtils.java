package com.wj.login.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Project : servlet_login
 * @Package : com.wj.login.utils
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 19:09
 **/
public class JDBCUtils {

    private static DataSource ds;

    /**
     * 初始化
     */
    static {
        try {
            // 读取配置文件
            Properties properties = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            // 初始化连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource() {

        return ds;
    }

    /**
     * 获取连接对象
     * */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
