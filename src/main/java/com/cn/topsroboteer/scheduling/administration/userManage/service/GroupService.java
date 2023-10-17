package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Group;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
public interface GroupService extends IService<Group> {


    PageDataResult getGroups(Group group, Integer pageNum, Integer pageSize);

    boolean saveProjectToGroup(Group group);

    boolean editProjectOfGroup(Group group);
}
