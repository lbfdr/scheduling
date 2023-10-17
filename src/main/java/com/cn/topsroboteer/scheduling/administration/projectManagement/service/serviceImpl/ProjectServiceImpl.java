package com.cn.topsroboteer.scheduling.administration.projectManagement.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.topsroboteer.scheduling.administration.projectManagement.dao.ProjectMapper;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.projectManagement.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author libofan
 * @since 2023-09-08
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public PageInfo<Project> getProjectsAsc(Project project, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Project> projectList = projectMapper.selectProjectsAsc(project);
        return new PageInfo<>(projectList);
    }

    @Override
    public PageInfo<Project> getProjectsDesc(Project project, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Project> projectList = projectMapper.selectProjectsDesc(project);
        return new PageInfo<>(projectList);
    }
}
