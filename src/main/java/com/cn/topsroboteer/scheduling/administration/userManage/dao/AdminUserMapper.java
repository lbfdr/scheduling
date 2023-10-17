package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author zhang
 * @Date 2022/5/17 16:50
 */
@Mapper
public interface AdminUserMapper {

    List<AdminUser> list(AdminUser adminUser);

    int add(AdminUser adminUser);


    int edit(AdminUser adminUser);

    int del(String id);

    AdminUser selectByAdminUser(String username);


    AdminUser selectByPrimaryKey(String id);


    String selectTokenByUid(Long uid);
}
