package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Group;
import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

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
@TableName("tbl_group")
@ApiModel(value = "Group对象", description = "")
@Data
public class GroupDTO extends BaseDTO {


    @ApiModelProperty("主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("小组名")
    @TableField("group_name")
    private String groupName;

    @ApiModelProperty("部门id")
    @TableField("department_id")
    private String departmentId;

    @ApiModelProperty("部门名")
    @TableField(exist = false)
    private String departmentName;

    @ApiModelProperty("小组组长id")
    @TableField("group_leader")
    private String groupLeader;

    @ApiModelProperty("小组组长名")
    @TableField(exist = false)
    private String groupLeaderName;

    @ApiModelProperty("小组成员")
    @TableField(exist = false)
    private List<GroupMember> memberList;
    public Group convertToGroup(){
        GroupDTOConvert groupDTOConvert = new GroupDTOConvert();
        return groupDTOConvert.doForward(this);
    }
    private static class GroupDTOConvert extends BaseDtoConvert<GroupDTO, Group> {
        @Override
        protected Group doForward(GroupDTO groupDTO) {
            Group group = new Group();
            //将给定源 bean 的属性值复制到目标 bean 中
            BeanUtils.copyProperties(groupDTO, group);
            return group;
        }

        @Override
        protected GroupDTO doBackward(Group group) {
            return null;
        }
    }
}
