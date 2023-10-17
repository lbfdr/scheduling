package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;

import java.util.List;

public interface TaskMapper {

    List<Task> list(Task task);

    int addTask(Task task);

    int upTask(Task task);

    int delTask(Task task);
}
