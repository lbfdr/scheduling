package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Daily;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

import java.util.List;

public interface DailyService {

    PageDataResult list(Daily daily,Integer pageNum,Integer pageSize);

    List<Daily> selDaily(Daily daily);

    int add(List<Daily> daily);

    int update(List<Daily> daily);

    int delete(Daily daily);
}
