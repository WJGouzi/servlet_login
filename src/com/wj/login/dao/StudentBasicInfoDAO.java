package com.wj.login.dao;

import com.wj.login.domain.StudentBasicInfoBean;
import com.wj.login.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Project : servlet_login
 * @Package : com.wj.login.dao
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 19:08
 **/
public class StudentBasicInfoDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据id值进行查询
     * @param studentBasicInfoBean 学生的数据模型
     */
    public StudentBasicInfoBean queryWithId(StudentBasicInfoBean studentBasicInfoBean) {
        try {
            String sql = "select * from t_studentBasicInfo where id = ?";
            StudentBasicInfoBean student = template.queryForObject(sql, new BeanPropertyRowMapper<>(studentBasicInfoBean.getClass()), studentBasicInfoBean.getId());
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 登录操作
     * @param studentBean
     */
    public StudentBasicInfoBean login(StudentBasicInfoBean studentBean) {
        try {
            String sql = "select * from t_studentBasicInfo where login_name = ? and password = ?";
            StudentBasicInfoBean student = template.queryForObject(sql, new BeanPropertyRowMapper<>(studentBean.getClass()), studentBean.getLoginName(), studentBean.getPassword());
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
