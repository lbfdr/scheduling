package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class TaskDTO extends BaseDTO{

    private String id;

    private String taskName;

    private String taskDescribe;

    private String projectName;
    private String projectId;

    private String classification;

    private String details;

    private String state;

    private String stateRemarks;

    private String proposeName;
    private String proposeId;

    private Date expectedDate;

    private String remarks;

    private String departmentName;
    private String departmentId;

    private String assignState;

    private String assignName;
    private String assignId;

    private String handlerName;
    private String handlerId;

    private String estimateDate;

    private Date createTime;

    private Date confirmationDate;

    private Date processingTime;

    private Date completionTime;



    public Task convertToAllocation(){
        TaskConvert taskConvert = new TaskConvert();
        return taskConvert.doForward(this);
    }

    private static class TaskConvert extends BaseDtoConvert<TaskDTO, Task>{
        @Override
        protected Task doForward(TaskDTO taskDTO) {
            Task task = new Task();
            BeanUtils.copyProperties(taskDTO, task);
            return task;
        }

        @Override
        protected TaskDTO doBackward(Task task) {
            return null;
        }
    }

}
