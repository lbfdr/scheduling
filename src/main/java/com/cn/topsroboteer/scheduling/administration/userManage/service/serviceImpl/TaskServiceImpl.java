package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.TaskMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import com.cn.topsroboteer.scheduling.administration.userManage.service.TaskService;
import com.cn.topsroboteer.scheduling.utils.DateUtil;
import com.cn.topsroboteer.scheduling.utils.IdUtils;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private TaskMapper taskMapper;

    @Override
    @Transactional
    public PageDataResult list(Task task, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult=new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<Task> list = taskMapper.list(task);
        if (list.size()>0){
            PageInfo<Task> pageInfo=new PageInfo<>(list);
            pageDataResult.setList(pageInfo.getList());
            pageDataResult.setTotals((int)pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    @Transactional
    public int addTask(Task task) {
        task.setId(IdUtils.getSeqId().toString());
        String s = DateUtil.currentDateTime();
        try {
            Date parse = sdf.parse(s);
            task.setCreateTime(parse);
            int i = taskMapper.addTask(task);
            if (i>0){
                return 1;
            }else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional
    public int upTask(Task task) {
        String s = DateUtil.currentDateTime();
        try {
            Date parse = sdf.parse(s);
            task.setCreateTime(parse);
            int i = taskMapper.upTask(task);
            if (i>0){
                return 1;
            }else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional
    public int delTask(Task task) {
        int i = taskMapper.delTask(task);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
