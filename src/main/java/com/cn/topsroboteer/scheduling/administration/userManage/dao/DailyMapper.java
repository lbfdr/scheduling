package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Daily;

import java.util.List;

public interface DailyMapper {

    List<Daily> list(Daily daily);

    int add(Daily daily);

    int update(Daily daily);

    int delete(Daily daily);
}
