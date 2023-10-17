package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.AuthRoleRefMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AuthRoleRef;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AuthRoleRefService;
import com.cn.topsroboteer.scheduling.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthRoleRefServiceImpl implements AuthRoleRefService {

    @Autowired
    private AuthRoleRefMapper authRoleRefMapper;

    @Override
    @Transactional
    public int upAuthRoleRef(AuthRoleRef authRoleRef) {
        AuthRoleRef list = authRoleRefMapper.list(authRoleRef);
        if (list!=null){
            //先删除旧的
            int i = authRoleRefMapper.delAuthRoleRef(authRoleRef);
            authRoleRef.setId(IdUtils.getSeqId().toString());
            //再添加新的
            int i1 = authRoleRefMapper.addAuthRoleRef(authRoleRef);
            if (i>0&&i1>0){
                return 1;
            }else {
                return 0;
            }
        }else {
            int i = authRoleRefMapper.addAuthRoleRef(authRoleRef);
            if (i>0){
                return 1;
            }else {
                return 0;
            }
        }
    }
}
