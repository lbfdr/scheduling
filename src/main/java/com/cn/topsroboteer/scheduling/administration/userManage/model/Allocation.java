package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;

import java.util.Date;

@Data
public class Allocation {

    private String id;

    private String taskId;

    private String taskName;

    private String handlerId;

    private String handlerName;

    private Date estimateDate;
}
