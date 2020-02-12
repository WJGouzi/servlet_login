package com.wj.login.test;

import com.wj.login.dao.StudentBasicInfoDAO;
import com.wj.login.domain.StudentBasicInfoBean;
import org.junit.Test;

/**
 * @Project : servlet_login
 * @Package : com.wj.login.test
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 19:42
 **/
public class DaoTest {
    private StudentBasicInfoDAO studentBasicInfoDAO = new StudentBasicInfoDAO();

    @Test
    public void queryWithIdTest () {
        StudentBasicInfoBean studentBasicInfoBean = new StudentBasicInfoBean();
        studentBasicInfoBean.setId(1);
        StudentBasicInfoBean s = studentBasicInfoDAO.queryWithId(studentBasicInfoBean);
        System.out.println(s);
    }

    @Test
    public void loginTest() {
        StudentBasicInfoBean studentBasicInfoBean = new StudentBasicInfoBean();
        studentBasicInfoBean.setLoginName("wj");
        studentBasicInfoBean.setPassword("123456");
        StudentBasicInfoBean infoBean = studentBasicInfoDAO.login(studentBasicInfoBean);
        System.out.println(infoBean);
    }
}
