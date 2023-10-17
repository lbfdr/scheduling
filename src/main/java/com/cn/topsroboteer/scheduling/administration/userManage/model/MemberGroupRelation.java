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
 * @since 2023-09-13
 */
@Getter
@Setter
@TableName("member_group_relation")
@ApiModel(value = "MemberGroupRelation对象", description = "")
public class MemberGroupRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId("id")
    private String id;

    @ApiModelProperty("人员id")
    @TableField("member_id")
    private String memberId;

    @ApiModelProperty("小组id")
    @TableField("group_id")
    private String groupId;


}
