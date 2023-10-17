package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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
public class GroupMemberDTO extends  BaseDTO {


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
    public GroupMember convertToGroupMember(){
        GroupMemberDTOConvert groupMemberDTOConvert = new GroupMemberDTOConvert();
        return groupMemberDTOConvert.doForward(this);
    }
    private static class GroupMemberDTOConvert extends BaseDtoConvert<GroupMemberDTO,GroupMember>{
        @Override
        protected GroupMember doForward(GroupMemberDTO groupMemberDTO) {
            GroupMember groupMember = new GroupMember();
            BeanUtils.copyProperties(groupMemberDTO,groupMember);
            return groupMember;
        }

        @Override
        protected GroupMemberDTO doBackward(GroupMember groupMember) {
            return null;
        }
    }
}
