package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.AdminUserMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.UserDepartmentRefMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import com.cn.topsroboteer.scheduling.administration.userManage.model.UserDepartmentRef;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AdminUserService;
import com.cn.topsroboteer.scheduling.exception.ForBiddenException;
import com.cn.topsroboteer.scheduling.utils.EncryptionUtils;
import com.cn.topsroboteer.scheduling.utils.IdUtils;
import com.cn.topsroboteer.scheduling.utils.JWTUtils;
import com.cn.topsroboteer.scheduling.utils.PageDataResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author zhang
 * @Date 2022/5/17 16:44
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private UserDepartmentRefMapper userDepartmentRefMapper;

    @Override
    public PageDataResult list(AdminUser adminUser, Integer pageNum, Integer pageSize) {

        PageDataResult pageDataResult = new PageDataResult();

        PageHelper.startPage(pageNum,pageSize);

        List<AdminUser> list = adminUserMapper.list(adminUser);

        if (list.size()>0){
            PageInfo<AdminUser> pageInfo = new PageInfo<>(list);

            pageDataResult.setTotals((int)pageInfo.getTotal());
            pageDataResult.setList(list);

        }
        return pageDataResult;
    }


    @Transactional
    @Override
    public int add(AdminUser adminUser) {

        String s = IdUtils.getSeqId().toString();
        adminUser.setId(s);
        String password = adminUser.getPassword();
        adminUser.setPassword(EncryptionUtils.md5AndSalt(password));
        adminUser.setCreateTime(new Date());
        int i = adminUserMapper.add(adminUser);

        if (i>0){

            UserDepartmentRef userDepartmentRef = new UserDepartmentRef();
            userDepartmentRef.setId(IdUtils.getSeqId().toString());
            userDepartmentRef.setUserId(s);
            userDepartmentRef.setDepartment(adminUser.getDepartmentId());
            userDepartmentRef.setCreateTime(new Date());
            userDepartmentRef.setUpdateTime(new Date());

            int add = userDepartmentRefMapper.add(userDepartmentRef);
        }
        return i;
    }


    @Transactional
    @Override
    public int edit(AdminUser adminUser) {

        adminUser.setUpdateTime(new Date());

        int i = adminUserMapper.edit(adminUser);
        if (i>0){

          UserDepartmentRef userDepartmentRef = userDepartmentRefMapper.selectUserIdByDepartment(adminUser.getId());
          if (!userDepartmentRef.getDepartment().equals(adminUser.getDepartmentId()) ){
              userDepartmentRef.setDepartment(adminUser.getDepartmentId());
              userDepartmentRef.setUpdateTime(new Date());
              int edit = userDepartmentRefMapper.edit(userDepartmentRef);
          }

        }

        return i;
    }

    @Override
    public int del(String id) {

       int i =  adminUserMapper.del(id);

       return i;
    }

    @Override
    public boolean adminAuthorization(String token) {

        if (StringUtils.isEmpty(token)) {
            throw new ForBiddenException();
        }
        Long uid = JWTUtils.getUid(token);
        String tokenByAdmin = adminUserMapper.selectTokenByUid(uid);
        return StringUtils.equals(token, tokenByAdmin);



    }
}
