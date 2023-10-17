package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author zhang
 * @Date 2022/5/18 10:07
 */
@Data
public class UserDepartmentRef {

    private String id;

    private String userId;

    private String department;

    private Date createTime;

    private Date updateTime;

}
