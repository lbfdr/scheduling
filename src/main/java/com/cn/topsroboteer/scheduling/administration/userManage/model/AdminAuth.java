package com.cn.topsroboteer.scheduling.administration.userManage.model;

import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class AdminAuth  {

    private String id;

    private String authName;

    private String level;

    private String pid;

    private String createName;
    private String createId;

    private Date createTime;

    private String updateId;
    private String updateName;

    private Date updateTime;

    private String state;
}
