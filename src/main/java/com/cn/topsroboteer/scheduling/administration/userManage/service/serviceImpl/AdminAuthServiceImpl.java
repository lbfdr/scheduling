package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.AdminAuthMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AdminAuthService;
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
public class AdminAuthServiceImpl implements AdminAuthService {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AdminAuthMapper adminAuthMapper;

    @Override
    @Transactional
    public PageDataResult list(AdminAuth adminAuth, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<AdminAuth> list = adminAuthMapper.list(adminAuth);
        if (list.size()>0){
            PageInfo<AdminAuth> pageInfo=new PageInfo<>(list);
            pageDataResult.setList(pageInfo.getList());
            pageDataResult.setTotals((int)pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    @Transactional
    public int addAdminAuth(AdminAuth adminAuth) {
        adminAuth.setId(IdUtils.getSeqId().toString());
        String s = DateUtil.currentDateTime();
        try {
            Date date = sdf.parse(s);
            adminAuth.setCreateTime(date);
            int i = adminAuthMapper.addAdminAuth(adminAuth);
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
    public int upAdminAuth(AdminAuth adminAuth) {
        String s = DateUtil.currentDateTime();
        try {
            Date date = sdf.parse(s);
            adminAuth.setUpdateTime(date);
            int i = adminAuthMapper.upAdminAuth(adminAuth);
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
    public int delAdminAuth(AdminAuth adminAuth) {
        int i = adminAuthMapper.delAdminAuth(adminAuth);
        if (i>0){
            return 1;
        }else {
            return 0;
        }
    }
}
