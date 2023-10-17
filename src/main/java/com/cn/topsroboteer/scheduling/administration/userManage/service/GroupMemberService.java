package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import com.github.pagehelper.PageInfo;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
public interface GroupMemberService extends IService<GroupMember> {
    PageInfo<GroupMember> queryGroupMemberList(GroupMember groupMember, Integer pageNum, Integer pageSize);
}
