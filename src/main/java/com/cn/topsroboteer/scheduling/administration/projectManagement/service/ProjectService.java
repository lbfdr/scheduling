package com.cn.topsroboteer.scheduling.administration.projectManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author libofan
 * @since 2023-09-08
 */
public interface ProjectService extends IService<Project> {
    PageInfo<Project> getProjectsAsc(Project project, Integer pageNum, Integer pageSize);
    PageInfo<Project> getProjectsDesc(Project project, Integer pageNum, Integer pageSize);
}
