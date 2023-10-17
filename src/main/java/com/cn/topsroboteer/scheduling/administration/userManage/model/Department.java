package com.cn.topsroboteer.scheduling.administration.userManage.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("department")
@ApiModel(value = "Department对象", description = "")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;

    @ApiModelProperty("部门名称")
    @TableField("department_name")
    private String departmentName;

    @ApiModelProperty("排序")
    @TableField("sort")
    private String sort;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    @TableField("is_del")
    private String isDel;


}
