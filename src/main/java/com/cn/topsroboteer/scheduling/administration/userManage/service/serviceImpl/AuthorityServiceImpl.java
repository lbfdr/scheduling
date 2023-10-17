package com.cn.topsroboteer.scheduling.administration.userManage.service.serviceImpl;

import com.cn.topsroboteer.scheduling.administration.userManage.dao.AdminAuthMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.AdminUserMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.dao.AuthRoleRefMapper;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import com.cn.topsroboteer.scheduling.administration.userManage.service.AuthorityService;
import com.cn.topsroboteer.scheduling.exception.InformationErrorException;
import com.cn.topsroboteer.scheduling.exception.UserNotFoundException;
import com.cn.topsroboteer.scheduling.utils.EncryptionUtils;
import com.cn.topsroboteer.scheduling.utils.JWTUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author zhang
 * @Date 2022/5/19 9:59
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AuthRoleRefMapper authRoleRefMapper;

    @Autowired
    private AdminAuthMapper adminAuthMapper;

    @Override
    public AdminUser login(String username, String password) {

        AdminUser adminUser = adminUserMapper.selectByAdminUser(username);

        if (Objects.isNull(adminUser)) {
            throw new UserNotFoundException("用户不存在");
        }
       /* if ("1".equals(adminUser.getIsDel())){
            throw new InformationErrorException("用户已删除");
        }*/
        // 对传入的密码进行MD5盐值加密
        password = EncryptionUtils.md5AndSalt(password);
        //比较传入的和数据库查询的密码的密文
        if (!StringUtils.equals(password, adminUser.getPassword())) {
            throw new InformationErrorException("用户信息有误");
        }

        adminUser.setLoginTime(new Date());
        adminUser.setToken(JWTUtils.sign(adminUser.getUserName(), Long.valueOf(adminUser.getId()) , adminUser.getPassword() + adminUser.getPhone()));
        int edit = adminUserMapper.edit(adminUser);
        if (edit == 0){
            throw new RuntimeException("服务器开小差了");
        }else{
            adminUser.setPassword(null);
            return adminUser;
        }

    }



    /*@Override
    public List<AdminAuths> navigationAuth(String id) {

        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(id);

        if (Objects.isNull(adminUser)) {
            throw new UserNotFoundException("用户不存在");
        }
        if ("1".equals(adminUser.getIsDel())){
            throw new InformationErrorException("用户已删除");
        }

        String rolesId = adminUser.getRolesId();

        List<AdminAuths> list  = authRoleRefMapper.selectRolesAuth(rolesId);

        for (AdminAuths adminAuths : list) {

           List<AdminAuths> listT =  adminAuthMapper.selectPidByAdminAuth(adminAuths.getId());
//           this.getMenuTreeList(listT,adminAuths.getId());
            if (listT.size()>0){
                for (AdminAuths auths : listT) {

                    List<AdminAuths> listC =  adminAuthMapper.selectPidByAdminAuth(auths.getId());
                    if (!org.springframework.util.StringUtils.isEmpty(listC)){
                        auths.setAuthsList(listC);
                    }
                }
            }

            if (!org.springframework.util.StringUtils.isEmpty(listT)){
                adminAuths.setAuthsList(listT);
            }
        }


        return list;
    }


    private List<AdminAuths> getMenuTreeList(List<AdminAuths> menuList,String pid) {
        // 查找所有菜单
        List<AdminAuths> childrenList = new ArrayList<>();
        menuList.forEach(menu -> {
            if (Objects.equals(pid, menu.getPid())) {
                menu.setAuthsList(getMenuTreeList(menuList, menu.getId()));
                childrenList.add(menu);
            }
        });
        return childrenList;
    }*/
}
