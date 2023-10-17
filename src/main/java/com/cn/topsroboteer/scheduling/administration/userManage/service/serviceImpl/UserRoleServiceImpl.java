package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.UserRoleMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.UserRole;
import com.cn.topsroboteer.scheduling.administration.userManage.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public PageDataResult list(UserRole userRole, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult=new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<UserRole> list = userRoleMapper.list(userRole);
        if (list.size()>0){
            PageInfo<UserRole> pageInfo=new PageInfo<>(list);
            pageDataResult.setList(pageInfo.getList());
            pageDataResult.setTotals((int)pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    @Transactional
    public int addUserRole(UserRole userRole) {
        userRole.setId(IdUtils.getSeqId().toString());
        String s = DateUtil.currentDateTime();
        try {
            Date date = sdf.parse(s);
            userRole.setCreateTime(date);
            int i = userRoleMapper.addUserRole(userRole);
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
    public int upUserRole(UserRole userRole) {
        String s = DateUtil.currentDateTime();
        try {
            Date date = sdf.parse(s);
            userRole.setUpdateTime(date);
            int i = userRoleMapper.upUserRole(userRole);
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
    public int delUserRole(UserRole userRole) {
        int i = userRoleMapper.delUserRole(userRole);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
