package com.cn.topsroboteer.scheduling.administration.userManage.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
@Getter
@Setter
@TableName("group_member")
@ApiModel(value = "GroupMember对象", description = "")
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("成员id")
    @TableId("id")
    private String id;

    @ApiModelProperty("成员名")
    @TableField("member_name")
    private String memberName;

    @ApiModelProperty("职位")
    @TableField("position")
    private String position;

    @ApiModelProperty("手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("部门id")
    @TableField("department_id")
    private String departmentId;

    @ApiModelProperty("部门名")
    @TableField(exist = false)
    private String departmentNames;
}
