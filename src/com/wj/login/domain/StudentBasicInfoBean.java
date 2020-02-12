package com.wj.login.domain;

/**
 * @Project : servlet_login
 * @Package : com.wj.login.domain
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/12 17:22
 **/

/**
 * 表的结果如下
 * CREATE TABLE `t_studentBasicInfo` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(255) NOT NULL,
 *   `id_card` varchar(18) NOT NULL,
 *   `address` varchar(255) DEFAULT NULL,
 *   `age` int(11) DEFAULT NULL,
 *   `height` float DEFAULT NULL,
 *   `gender` tinyint(1) DEFAULT NULL,
 *   `login_name` varchar(255) DEFAULT NULL,
 *   `password` varchar(16) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */


public class StudentBasicInfoBean {

    private Integer id;
    private String name;
    private String idCard;
    private String address;
    private Integer age;
    private Float height;
    private Boolean gender; // false 是女性 true是男性
    private String loginName;
    private String password;

    public StudentBasicInfoBean() {
    }


    public StudentBasicInfoBean(Integer id, String name, String idCard, String address, Integer age, Float height, Boolean gender, String loginName, String password) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.address = address;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.loginName = loginName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "StudentBasicInfoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", gender=" + gender +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    // 这里的setter和getter方法是为了解决属性和成员变量不一致在成解析错误的问题
    public String getUsername () {
        return this.getLoginName();
    }

    public void setUsername (String username) {
        this.setLoginName(username);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
