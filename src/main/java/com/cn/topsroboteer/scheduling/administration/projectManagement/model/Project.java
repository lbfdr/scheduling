package com.cn.topsroboteer.scheduling.administration.projectManagement.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author libofan
 * @since 2023-09-08
 */
@Getter
@Setter
@TableName("project")
@ApiModel(value = "Project对象", description = "")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @ApiModelProperty("项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty("项目任务")
    @TableField("project_task")
    private String projectTask;

    @ApiModelProperty("优先级")
    @TableField("priority")
    private String priority;

    @ApiModelProperty("计划开始时间")
    @TableField("start_up_time")
    private LocalDate startUpTime;

    @ApiModelProperty("计划结束时间")
    @TableField("completion_time")
    private LocalDate completionTime;

    @ApiModelProperty("天数（单独）")
    @TableField("day_of_alone")
    private String dayOfAlone;

    @ApiModelProperty("天数（并行2）")
    @TableField("day_of_two")
    private String dayOfTwo;

    @ApiModelProperty("天数（并行3）")
    @TableField("day_of_three")
    private String dayOfThree;

    @ApiModelProperty("天数（并行4）")
    @TableField("day_of_four")
    private String dayOfFour;

    @ApiModelProperty("项目负责人id")
    @TableField("admin_user_id")
    private String adminUserId;

    @ApiModelProperty("项目负责人姓名")
    @TableField(exist = false)
    private String adminUserName;

    @ApiModelProperty("项目级别")
    @TableField("level")
    private String level;

    @ApiModelProperty("是否并行 1， 并行 0 不并行")
    @TableField("is_parallel")
    private String isParallel;
}
