package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.UserRole;

import java.util.List;

public interface UserRoleMapper {
    List<UserRole> list(UserRole userRole);

    int addUserRole(UserRole userRole);

    int upUserRole(UserRole userRole);

    int delUserRole(UserRole userRole);
}
