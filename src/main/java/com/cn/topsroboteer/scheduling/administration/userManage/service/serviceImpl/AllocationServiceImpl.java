package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.AllocationMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AllocationService;
import com.cn.topsroboteer.scheduling.administration.userManage.service.TaskService;
import com.cn.topsroboteer.scheduling.utils.IdUtils;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AllocationMapper allocationMapper;
    /*@Autowired
    private TaskService taskService;*/

    @Override
    @Transactional
    public PageDataResult list(Allocation allocation, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult=new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<Allocation> list = allocationMapper.list(allocation);
        if (list.size()>0){
            PageInfo<Allocation> pageInfo=new PageInfo<>(list);
            pageDataResult.setList(pageInfo.getList());
            pageDataResult.setTotals((int)pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    @Transactional
    public int addAllocation(List<Allocation> list) {
        int i=0;
        for (Allocation allocation : list){
             allocation.setId(IdUtils.getSeqId().toString());
             allocationMapper.addAllocation(allocation);
             i++;
        }
        if (i==list.size()){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int upAllocation(Allocation allocation) {
        int i = allocationMapper.upAllocation(allocation);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int delAllocation(Allocation allocation) {
        int i = allocationMapper.delAllocation(allocation);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
