package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

/**
 * @Author zhang
 * @Date 2022/5/17 16:44
 */
public interface AdminUserService {
    PageDataResult list(AdminUser adminUser, Integer pageNum, Integer pageSize);

    int add(AdminUser adminUser);

    int edit(AdminUser adminUser);

    int del(String id);

    boolean adminAuthorization(String token);

}
