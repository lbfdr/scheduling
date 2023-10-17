package com.cn.topsroboteer.scheduling.administration.userManage.service;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;

public interface TaskService {

    PageDataResult list(Task task, Integer pageNum, Integer pageSize);

    int addTask(Task task);

    int upTask(Task task);

    int delTask(Task task);


}
