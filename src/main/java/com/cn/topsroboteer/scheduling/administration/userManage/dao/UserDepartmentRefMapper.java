package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.UserDepartmentRef;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhang
 * @Date 2022/5/18 10:03
 */
@Mapper
public interface UserDepartmentRefMapper {

    int add(UserDepartmentRef userDepartmentRef);

    int edit(UserDepartmentRef userDepartmentRef);

    int del(String userId);

    int list(UserDepartmentRef userDepartmentRef);

    UserDepartmentRef selectUserIdByDepartment(String userId);

}
