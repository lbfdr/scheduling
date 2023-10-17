package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author zhang
 * @Date 2022/5/17 16:14
 */
@Data
public class AdminUser {

    private String id;

    private String userName;

    private String adminUid;

    private String password;

    private String rolesId;

    private String phone;

    private String token;

    private Date loginTime;

    private Date createTime;

    private Date updateTime;

    private String isDel;

    private String sex;

    private String postId;

    /*以下属性在数据表中没有对应的字段*/

    private String departmentId;
    private String postName;
    private String departmentName;


}
