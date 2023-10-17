package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

public interface AdminAuthService {

    PageDataResult list(AdminAuth adminAuth, Integer pageNum, Integer pageSize);

    int addAdminAuth(AdminAuth adminAuth);

    int upAdminAuth(AdminAuth adminAuth);

    int delAdminAuth(AdminAuth adminAuth);
}
