package com.cn.topsroboteer.scheduling.administration.projectManagement.model.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.TaskAllocation;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDTO;
import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDtoConvert;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @Author zhang
 * @Date 2022/5/17 9:53
 */
@Data
public class TaskAllocationDTO extends BaseDTO {

    private Long id;
    @Excel(name = "开发人员",orderNum = "1" ,width = 20)
    private String userName;
    @Excel(name = "项目名称",orderNum = "2" ,width = 20)
    private String  projectName;
    @Excel(name = "项目任务",orderNum = "3" ,width = 20)
    private  String projectTask;

    @Excel(name = "创建时间",orderNum = "4" ,width = 20)
    private Date createTime;
    @Excel(name = "修改时间",orderNum = "5" ,width = 20)
    private Date updateTime;
    @Excel(name = "项目开始时间",orderNum = "8" ,width = 20)
    private String timeNodeStart;
    @Excel(name = "时间节点",orderNum = "8" ,width = 20)
    private String deadline;//如果java实体类日期类型为Date，前端传的参数必须带上时分秒，不然报400错误
    @Excel(name = "状态",orderNum = "9" ,width = 20)
    private String ifComplete;
    @Excel(name = "备注",orderNum = "10" ,width = 20)
    private String remarks;
    @Excel(name = "优先级",orderNum = "10" ,width = 20)
    private String priority;

    private String days;


    public TaskAllocation convertToTaskAllocation(){
        TaskAllocationConvert taskAllocationConvert = new TaskAllocationConvert();
        return taskAllocationConvert.doForward(this);
    }

    private static class TaskAllocationConvert extends BaseDtoConvert<TaskAllocationDTO, TaskAllocation> {
        @Override
        protected TaskAllocation doForward(TaskAllocationDTO taskAllocationDTO) {
            TaskAllocation taskAllocation = new TaskAllocation();
            BeanUtils.copyProperties(taskAllocationDTO, taskAllocation);
            return taskAllocation;
        }

        @Override
        protected TaskAllocationDTO doBackward(TaskAllocation taskAllocation) {
            return null;
        }
    }




}
