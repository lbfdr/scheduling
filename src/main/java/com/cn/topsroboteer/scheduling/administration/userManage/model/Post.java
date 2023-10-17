package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;

import java.util.Date;

@Data
public class Post {



    private String postId;

    private String postName;

    private String sort;


    private Date createTime;

    private Date updateTime;

    private String isDel;
}
