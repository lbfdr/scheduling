package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

import java.util.List;

public interface AllocationService {

    PageDataResult list(Allocation allocation, Integer pageNum, Integer pageSize);

    int addAllocation(List<Allocation> list);

    int upAllocation(Allocation allocation);

    int delAllocation(Allocation allocation);
}
