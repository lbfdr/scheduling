package com.cn.topsroboteer.scheduling.administration.userManage.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Daily {

    private String id;

    private String dateType;

    private Date dailyDate;

    private String content;

    private String duration;

    private String workType;

    private String projectId;
    private String projectName;

    private String taskId;
    private String taskName;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss" )
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss" )
    private Date endDate;

    private String userId;

    private String userName;
}
