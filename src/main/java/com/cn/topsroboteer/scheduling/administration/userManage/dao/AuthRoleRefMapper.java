package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AuthRoleRef;

import java.util.List;

public interface AuthRoleRefMapper {

    AuthRoleRef list(AuthRoleRef authRoleRef);

    int addAuthRoleRef(AuthRoleRef authRoleRef);

    int delAuthRoleRef(AuthRoleRef authRoleRef);


    /*List<AdminAuths> selectRolesAuth(String rolesId);*/


}
