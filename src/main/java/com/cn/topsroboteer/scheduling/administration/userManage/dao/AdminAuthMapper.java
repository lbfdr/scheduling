package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;

import java.util.List;


public interface AdminAuthMapper {

    List<AdminAuth> list(AdminAuth adminAuth);

    int addAdminAuth(AdminAuth adminAuth);

    int upAdminAuth(AdminAuth adminAuth);

    int delAdminAuth(AdminAuth adminAuth);

    /*List<AdminAuths> selectPidByAdminAuth(String id);*/
}
