package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;

import java.util.List;

public interface AllocationMapper {

    List<Allocation> list(Allocation allocation);

    int addAllocation(Allocation allocation);

    int upAllocation(Allocation allocation);

    int delAllocation(Allocation allocation);
}
