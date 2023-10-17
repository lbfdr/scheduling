package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {

    private String id;

    private String roleName;

    private String createName;
    private String createId;

    private Date createTime;

    private String updateName;
    private String updateId;

    private Date updateTime;

    private String state;

}
