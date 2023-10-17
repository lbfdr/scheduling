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
 * @since 2023-10-17
 */
@Getter
@Setter
@TableName("project_group_relation")
@ApiModel(value = "ProjectGroupRelation对象", description = "")
public class ProjectGroupRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("小组id")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty("项目id")
    @TableField("project_id")
    private String projectId;


}
