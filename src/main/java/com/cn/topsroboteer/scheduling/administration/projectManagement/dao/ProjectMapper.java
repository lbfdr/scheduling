package com.cn.topsroboteer.scheduling.administration.projectManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author libofan
 * @since 2023-09-08
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
        List<Project> selectProjectsAsc(Project project);
        List<Project> selectProjectsDesc(Project project);
}
