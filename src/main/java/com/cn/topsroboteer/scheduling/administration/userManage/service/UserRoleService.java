package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.UserRole;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

public interface UserRoleService {
    PageDataResult list(UserRole userRole, Integer pageNum, Integer pageSize);

    int addUserRole(UserRole userRole);

    int upUserRole(UserRole userRole);

    int delUserRole(UserRole userRole);
}
