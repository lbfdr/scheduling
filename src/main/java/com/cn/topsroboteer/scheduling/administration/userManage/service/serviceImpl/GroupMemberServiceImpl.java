package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.DepartmentMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.GroupMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.GroupMemberMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.GroupMember;
import com.cn.topsroboteer.scheduling.administration.userManage.service.GroupMemberService;
import com.cn.topsroboteer.scheduling.administration.userManage.service.GroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupMemberServiceImpl extends ServiceImpl<GroupMemberMapper, GroupMember> implements GroupMemberService {
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupService groupService;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public PageInfo<GroupMember> queryGroupMemberList(GroupMember groupMember, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GroupMember> groupMemberList = groupMemberMapper.selectGroupMemberList(groupMember);
        return new PageInfo<>(groupMemberList);

    }

   /*@Override
    public boolean save(GroupMember entity) {
        try {
            //如果添加成员的所属的小组不存在，则先添加小组
           // groupService.save()
            QueryWrapper<Group> groupQueryWrapper = new QueryWrapper<>();
            groupQueryWrapper.eq(StringUtils.hasText(entity.getGroupId()),"id",entity.getGroupId());
            Group group = new Group();
            group.setDepartmentId(UUID.randomUUID().toString().replace("-",""));
            group.setGroupLeader(UUID.randomUUID().toString().replace("-",""));
            //小组添加失败
            if (!groupService.save(group)) {
                return false;
            }
            //再添加小组成员
            entity.setGroupId(group.getId());
            entity.setGroupLeader(group.getGroupLeader());
            groupMemberMapper.insert(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/

  /*  @Override
    public boolean updateById(GroupMember entity) {
        try {
            //修改成员记录
            groupMemberMapper.updateById(entity);
            //如果修改后成员所属的小组和组长不存在，则添加小组
            QueryWrapper<Group> groupQueryWrapper = new QueryWrapper<>();
            groupQueryWrapper.eq(StringUtils.hasText(entity.getGroupId()),"id",entity.getGroupId());
            groupQueryWrapper.eq(StringUtils.hasText(entity.getGroupLeader()),"group_leader",entity.getGroupLeader());
            Group group;
            if (groupMapper.selectOne(groupQueryWrapper) == null) {
                group=new Group();
                group.setId(entity.getGroupId());
                group.setGroupLeader(entity.getGroupLeader());
                group.setDepartmentId(UUID.randomUUID().toString().replace("-",""));
                groupMapper.insert(group);
                //添加完小组后，如果小组所属部门不存在，则添加部门
                QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper<>();
                departmentQueryWrapper.eq(StringUtils.hasText(group.getDepartmentId()),"id",group.getDepartmentId());
                if (departmentMapper.selectOne(departmentQueryWrapper) != null) {
                    Department department = new Department();
                    department.setId(group.getDepartmentId ());
                    department.setCreateTime(LocalDateTime.now());
                    departmentMapper.insert(department);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/

    @Override
    public boolean removeById(GroupMember entity) {
        return super.removeById(entity);
    }
}
