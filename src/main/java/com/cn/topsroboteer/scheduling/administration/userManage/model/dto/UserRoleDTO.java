package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Task;
import com.cn.topsroboteer.scheduling.administration.userManage.model.UserRole;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class UserRoleDTO extends BaseDTO {

    private String id;

    private String roleName;

    private String createName;
    private String createId;

    private Date createTime;

    private String updateName;
    private String updateId;

    private Date updateTime;

    private String state;


    public UserRole convertToAllocation(){
        UserRoleConvert userRoleConvert = new UserRoleConvert();
        return userRoleConvert.doForward(this);
    }

    private static class UserRoleConvert extends BaseDtoConvert<UserRoleDTO, UserRole>{
        @Override
        protected UserRole doForward(UserRoleDTO userRoleDTO) {
            UserRole userRole = new UserRole();
            BeanUtils.copyProperties(userRoleDTO, userRole);
            return userRole;
        }

        @Override
        protected UserRoleDTO doBackward(UserRole userRole) {
            return null;
        }
    }




}
