package com.cn.topsroboteer.scheduling.administration.projectManagement.dao;

import com.cn.topsroboteer.scheduling.administration.projectManagement.model.TaskAllocation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author zhang
 * @Date 2023/8/2 13:54
 */
@Mapper
public interface TaskAllocationMapper {
    List<TaskAllocation> list(Map<String, Object> search);


    int insertSelective(TaskAllocation taskAllocation);


    int updateSelective(TaskAllocation taskAllocation);


    int delete(String id);

    List<TaskAllocation> sortList();

    List<TaskAllocation> sortListAsc();
}
