package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;

import java.util.List;

/**
 * @Author zhang
 * @Date 2022/5/19 9:59
 */
public interface AuthorityService {
    AdminUser login(String username, String password);

    /*List<AdminAuths> navigationAuth(String id);*/

}
