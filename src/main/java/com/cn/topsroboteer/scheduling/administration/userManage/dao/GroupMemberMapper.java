package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
@Mapper
public interface GroupMemberMapper extends BaseMapper<GroupMember> {
    List<GroupMember> selectGroupMemberList(GroupMember groupMember);
}
