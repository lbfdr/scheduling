package com.cn.topsroboteer.scheduling.administration.userManage.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String id;

    @Excel(name = "任务名称",orderNum = "1" ,width = 20)
    private String taskName;

    @Excel(name = "任务描述",orderNum = "2" ,width = 20)
    private String taskDescribe;

    @Excel(name = "项目名称",orderNum = "3" ,width = 20)
    private String projectName;
    private String projectId;

    @Excel(name = "类型",orderNum = "4" ,width = 20)
    private String classification;

    @Excel(name = "详情",orderNum = "5" ,width = 20)
    private String details;

    @Excel(name = "状态",orderNum = "6" ,width = 20)
    private String state;

    @Excel(name = "状态备注",orderNum = "7" ,width = 20)
    private String stateRemarks;

    @Excel(name = "提出人",orderNum = "8" ,width = 20)
    private String proposeName;
    private String proposeId;

    @Excel(name = "期望时间",orderNum = "9" ,width = 20)
    private Date expectedDate;

    @Excel(name = "提出人备注",orderNum = "10" ,width = 20)
    private String remarks;

    @Excel(name = "部门",orderNum = "11" ,width = 20)
    private String departmentName;
    private String departmentId;

    @Excel(name = "指派状态",orderNum = "12" ,width = 20)
    private String assignState;

    @Excel(name = "指派人",orderNum = "13" ,width = 20)
    private String assignName;
    private String assignId;

    @Excel(name = "处理人",orderNum = "14" ,width = 20)
    private String handlerName;
    private String handlerId;

    @Excel(name = "预计时间",orderNum = "15" ,width = 20)
    private String estimateDate;

    @Excel(name = "提出时间",orderNum = "16" ,width = 20)
    private Date createTime;

    @Excel(name = "确认时间",orderNum = "17" ,width = 20)
    private Date confirmationDate;

    @Excel(name = "处理时间",orderNum = "18" ,width = 20)
    private Date processingTime;

    @Excel(name = "完成时间",orderNum = "19" ,width = 20)
    private Date completionTime;

}
