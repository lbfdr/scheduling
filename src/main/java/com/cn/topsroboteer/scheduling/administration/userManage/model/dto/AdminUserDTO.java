package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @Author zhang
 * @Date 2022/5/17 16:14
 */
@Data
public class AdminUserDTO extends BaseDTO {

    private String id;

    private String userName;

    private String adminUid;

    private String password;

    private String rolesId;

    private String phone;

    private String token;

    private Date loginTime;

    private Date createTime;

    private Date updateTime;

    private String isDel;

    private String sex;

    private String postId;

    /**/

    private String departmentId;
    private String postName;
    private String departmentName;


    public AdminUser convertToAdminUser(){
        AdminDtoConvert adminDtoConvert = new AdminDtoConvert();
        return adminDtoConvert.doForward(this);
    }

    private static class AdminDtoConvert extends BaseDtoConvert<AdminUserDTO, AdminUser>{
        @Override
        protected AdminUser doForward(AdminUserDTO adminUserDTO) {
            AdminUser adminUser = new AdminUser();
            BeanUtils.copyProperties(adminUserDTO, adminUser);
            return adminUser;
        }

        @Override
        protected AdminUserDTO doBackward(AdminUser adminUser) {
            return null;
        }
    }





}
