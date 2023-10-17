package com.cn.topsroboteer.scheduling.administration.projectManagement.service;

import com.cn.topsroboteer.scheduling.administration.projectManagement.model.TaskAllocation;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

/**
 * @Author zhang
 * @Date 2023/8/2 13:54
 */
public interface TaskAllocationService {
    PageDataResult list(TaskAllocation taskAllocation, Integer pageNum, Integer pageSize);


    int add(TaskAllocation taskAllocation);

    int edit(TaskAllocation taskAllocation);

    int del(String id);

    PageDataResult sortList( Integer pageNum, Integer pageSize);

    PageDataResult sortListAsc(Integer pageNum, Integer pageSize);
}
