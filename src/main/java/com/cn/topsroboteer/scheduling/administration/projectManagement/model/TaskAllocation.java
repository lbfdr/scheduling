package com.cn.topsroboteer.scheduling.administration.projectManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author zhang
 * @Date 2023/8/2 13:56
 */
@Data
public class TaskAllocation {

    private Long id;

    private String userName;

    private String  projectName;

    private  String projectTask;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String timeNodeStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String deadline;

    private String ifComplete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//指定服务器端返回给客户端的日期的 JSON 格式
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String remarks;
    private String priority;

    private String days;




}
