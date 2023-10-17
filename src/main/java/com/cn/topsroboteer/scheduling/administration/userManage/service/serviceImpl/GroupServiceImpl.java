package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.topsroboteer.scheduling.administration.projectManagement.dao.ProjectMapper;
import com.cn.topsroboteer.scheduling.administration.projectManagement.model.Project;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.*;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Group;
import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import com.cn.topsroboteer.scheduling.administration.userManage.model.MemberGroupRelation;
import com.cn.topsroboteer.scheduling.administration.userManage.model.ProjectGroupRelation;
import com.cn.topsroboteer.scheduling.administration.userManage.service.GroupService;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private MemberGroupRelationMapper memberGroupRelationMapper;

    @Autowired
    ProjectGroupRelationMapper projectGroupRelationMapper;

    @Override
    public PageDataResult getGroups(Group entity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查询小组信息
        Page<Group> page = groupMapper.selectGroups(entity);
        List<MemberGroupRelation> memberGroupRelations;
        List<ProjectGroupRelation> projectGroupRelations;
        List<GroupMember> members;
        List<Project> projects;
        LambdaQueryWrapper<MemberGroupRelation> mgrqw;
        LambdaQueryWrapper<ProjectGroupRelation> pgrqw;
        LambdaQueryWrapper<GroupMember> groupMemberLambdaQueryWrapper;
        LambdaQueryWrapper<Project> projectLambdaQueryWrapper;
        for (Group group : page) {
            //根据小组id查询人员小组关联表, 小组id,组员id （多对多关系）
            mgrqw = new LambdaQueryWrapper<>();
            mgrqw.eq(StringUtils.hasText(group.getId()), MemberGroupRelation::getGroupId, group.getId());
            //mgrqw.eq(StringUtils.hasText(group.getId()), m ->m.getGroupId(), group.getId());
            memberGroupRelations = memberGroupRelationMapper.selectList(mgrqw);
            //查询当前小组人员，并封装到小组中
            members = new ArrayList<>();
            //根据成员id查找成员信息
            GroupMember groupMember;
            for (MemberGroupRelation relation : memberGroupRelations) {
                groupMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
                //此处如果人员id为空字符串,则会查询全部
                if (!StringUtils.isEmpty(relation.getMemberId())) {
                    groupMemberLambdaQueryWrapper.eq(StringUtils.hasText(relation.getMemberId()), GroupMember::getId, relation.getMemberId());
                    groupMember = groupMemberMapper.selectOne(groupMemberLambdaQueryWrapper);
                    //把成员封装到成员集合中
                    if (groupMember != null) {
                        members.add(groupMember);
                    }
                }
            }
            pgrqw = new LambdaQueryWrapper<>();
            pgrqw.eq(StringUtils.hasText(group.getId()), ProjectGroupRelation::getGroupId, group.getId());
            projectGroupRelations = projectGroupRelationMapper.selectList(pgrqw);
            projects = new ArrayList<>();
            Project project;
            for (ProjectGroupRelation projectGroupRelation : projectGroupRelations) {
                projectLambdaQueryWrapper = new LambdaQueryWrapper<>();
                projectLambdaQueryWrapper.eq(StringUtils.hasText(projectGroupRelation.getProjectId()), Project::getId, projectGroupRelation.getProjectId());
                project = projectMapper.selectOne(projectLambdaQueryWrapper);
                if (project != null) {
                    projects.add(project);
                }
            }
            //把成员集合封装到当前小组中
            group.setMemberList(members);
            //把项目集合封装到当前小组中
            group.setProjectList(projects);
        }
        PageInfo<Group> pageInfo = new PageInfo<>(page);
        return new PageDataResult(((int) pageInfo.getTotal()), pageInfo.getList());
    }

    @Override
    @Transactional
    public boolean save(Group entity) {
        try {
            //添加时组长、部门是前端选的，因此必定存在。
            //添加小组记录  id, group_name, department_id, group_leader
            groupMapper.insert(entity);
            //创建小组的时候可以同时添加多个组员
            MemberGroupRelation relation;
            if (!StringUtils.isEmpty(entity.getMemberList())) {//添加人员不是必选的，entity.getMemberList()可能报空指针异常
                for (GroupMember member : entity.getMemberList()) {
                    //人员id不能为null或空串
                    if (!StringUtils.isEmpty(member.getId())) {
                        relation = new MemberGroupRelation();
                        relation.setGroupId(entity.getId());
                        relation.setMemberId(member.getId());
                        //添加组员和小组关系
                        memberGroupRelationMapper.insert(relation);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(Group entity) {
        try {
            //修改时组长、部门是前端选的，因此必定存在。
            //修改小组记录  id, group_name, department_id, group_leader
            groupMapper.updateById(entity);
            //修改组员和小组关系,覆盖掉小组原来的人员
            MemberGroupRelation relation;
            LambdaQueryWrapper<MemberGroupRelation> queryWrapper;
            //先删除之前的人员小组关系
            queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(StringUtils.hasText(entity.getId()), MemberGroupRelation::getGroupId, entity.getId());
            memberGroupRelationMapper.delete(queryWrapper);
            if (!StringUtils.isEmpty(entity.getMemberList())) {//修改人员不是必选的，entity.getMemberList()可能报空指针异常
                for (GroupMember member : entity.getMemberList()) {
                    //再添加新的人员小组关系
                    relation = new MemberGroupRelation();
                    relation.setGroupId(entity.getId());
                    relation.setMemberId(member.getId());
                    //queryWrapper.eq(StringUtils.hasText(entity.getId()), MemberGroupRelation::getGroupId, entity.getId());
                    memberGroupRelationMapper.insert(relation);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean removeById(Group entity) {
        try {
            //先删除小组记录
            super.removeById(entity);
            //再删除小组中的所有组员的信息（人员小组关系表)
            LambdaQueryWrapper<MemberGroupRelation> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(StringUtils.hasText(entity.getId()), MemberGroupRelation::getGroupId, entity.getId());
            MemberGroupRelation relation = new MemberGroupRelation();
            memberGroupRelationMapper.delete(queryWrapper);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveProjectToGroup(Group group) {
        List<Project> projectList = group.getProjectList();
        ProjectGroupRelation projectGroupRelation;
        try {
            if (!StringUtils.isEmpty(projectList)) {
                for (Project project : projectList) {
                    projectGroupRelation = new ProjectGroupRelation();
                    projectGroupRelation.setGroupId(group.getId());
                    projectGroupRelation.setProjectId(project.getId());
                    projectGroupRelationMapper.insert(projectGroupRelation);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editProjectOfGroup(Group group) {
        LambdaUpdateWrapper<ProjectGroupRelation> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(StringUtils.hasText(group.getId()), ProjectGroupRelation::getGroupId, group.getId());
        try {
            //1.在项目小组关系表中删除与该小组相关的记录
            projectGroupRelationMapper.delete(wrapper);
            //2.在项目小组关系表中重新添加与该小组的关联的项目
            saveProjectToGroup(group);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
