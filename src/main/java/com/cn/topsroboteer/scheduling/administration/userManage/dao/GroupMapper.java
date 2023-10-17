package com.cn.topsroboteer.scheduling.administration.userManage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Group;
import com.github.pagehelper.Page;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author libofan
 * @since 2023-09-10
 */
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
//    List<Group> selectGroups(Map<String,Object> map);
    //Page<Group> selectGroups(Map<String,Object> map);
    Page<Group> selectGroups(Group group);
    //

}
