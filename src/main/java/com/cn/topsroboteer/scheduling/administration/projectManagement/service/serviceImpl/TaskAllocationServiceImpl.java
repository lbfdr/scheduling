package com.cn.topsroboteer.scheduling.administration.projectManagement.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.projectManagement.dao.TaskAllocationMapper;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.TaskAllocation;
import com.cn.topsroboteer.scheduling.administration.projectManagement.service.TaskAllocationService;
import com.cn.topsroboteer.scheduling.utils.IdUtils;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.cn.topsroboteer.scheduling.utils.ToolUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhang
 * @Date 2023/8/2 13:54
 */
@Service
public class TaskAllocationServiceImpl  implements TaskAllocationService {

    @Autowired
    TaskAllocationMapper taskAllocationMapper;

    @Override
    public PageDataResult list(TaskAllocation taskAllocation,  Integer pageNum, Integer pageSize) {

        PageDataResult pageDataResult = new PageDataResult();
        Map<String, Object> search = new HashMap<>();
        if (!StringUtils.isEmpty(taskAllocation.getUserName())){
            search.put("userName",taskAllocation.getUserName());
        }
        if (!StringUtils.isEmpty(taskAllocation.getProjectName())){
            search.put("projectName",taskAllocation.getProjectName());
        }
        if (!StringUtils.isEmpty(taskAllocation.getPriority())){
            search.put("priority",taskAllocation.getPriority());
        }
        if (!StringUtils.isEmpty(taskAllocation.getPriority())){
            search.put("deadline",taskAllocation.getDeadline());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TaskAllocation> list = taskAllocationMapper.list(search);

        if (list.size() > 0 &&ToolUtil.isNotEmpty(list)){
            for (TaskAllocation allocation : list) {
                //格式化，去掉时分秒
                String timeNodeStart = allocation.getTimeNodeStart();
                if (timeNodeStart != null) {
                    allocation.setTimeNodeStart( timeNodeStart.substring(0,timeNodeStart.indexOf(" ")));
                }
                if (allocation.getDeadline() != null) {
                    allocation.setDeadline(allocation.getDeadline().substring(0,allocation.getDeadline().indexOf(" ")));
                }
            }
            PageInfo<TaskAllocation> pageInfo = new PageInfo<>(list);
            pageDataResult.setData(list);
            pageDataResult.setTotals((int)pageInfo.getTotal());
            pageDataResult.setCode(200);
        }

        return pageDataResult;

    }

    @Override
    public int add(TaskAllocation taskAllocation) {
        taskAllocation.setId(IdUtils.getSeqId());
        taskAllocation.setCreateTime(new Date());
        taskAllocation.setUpdateTime(new Date());
        int i = taskAllocationMapper.insertSelective(taskAllocation);

        return i;
    }

    @Override
    public int edit(TaskAllocation taskAllocation) {

        taskAllocation.setUpdateTime(new Date());

        int i = taskAllocationMapper.updateSelective(taskAllocation);

        return i;
    }

    @Override
    public int del(String id) {

        int i =  taskAllocationMapper.delete(id);
        return i;
    }

    @Override
    public PageDataResult sortList( Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<TaskAllocation> taskAllocationList = taskAllocationMapper.sortList();
        if (taskAllocationList.size()>0){
            for (TaskAllocation allocation : taskAllocationList) {
                //格式化，去掉时分秒
                String timeNodeStart = allocation.getTimeNodeStart();
                if (timeNodeStart != null) {
                    allocation.setTimeNodeStart( timeNodeStart.substring(0,timeNodeStart.indexOf(" ")));
                }
                if (allocation.getDeadline() != null) {
                    allocation.setDeadline(allocation.getDeadline().substring(0,allocation.getDeadline().indexOf(" ")));
                }
            }
        }
        PageInfo<TaskAllocation> pageInfo = new PageInfo<>(taskAllocationList);
        PageDataResult pageDataResult=new PageDataResult();
        pageDataResult.setData(pageInfo.getList());
        pageDataResult.setTotals(((int) pageInfo.getTotal()));
        return pageDataResult;
    }

    @Override
    public PageDataResult sortListAsc(Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<TaskAllocation> taskAllocationList = taskAllocationMapper.sortListAsc();
        if (taskAllocationList.size()>0) {
            for (TaskAllocation allocation : taskAllocationList) {
                //格式化，去掉时分秒
                String timeNodeStart = allocation.getTimeNodeStart();
                if (timeNodeStart != null) {
                    allocation.setTimeNodeStart( timeNodeStart.substring(0,timeNodeStart.indexOf(" ")));
                }
                if (allocation.getDeadline() != null) {
                    allocation.setDeadline(allocation.getDeadline().substring(0,allocation.getDeadline().indexOf(" ")));
                }
            }
        }
        PageInfo<TaskAllocation> pageInfo = new PageInfo<>(taskAllocationList);
        PageDataResult pageDataResult=new PageDataResult();
        pageDataResult.setData(pageInfo.getList());
        pageDataResult.setTotals(((int) pageInfo.getTotal()));
        return pageDataResult;
    }
}
