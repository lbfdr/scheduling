package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;

import java.util.Date;

@Data
public class AuthRoleRef {

    private String  id;

    private int menuId;

    private int userRoleId;

    private String createName;
    private String createId;

    private Date createTime;

    private String updateId;
    private String updateName;

    private Date updateTime;
}
