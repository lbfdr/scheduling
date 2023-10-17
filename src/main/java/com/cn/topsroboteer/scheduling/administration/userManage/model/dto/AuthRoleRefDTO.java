package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;
import com.cn.topsroboteer.scheduling.administration.userManage.model.AuthRoleRef;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class AuthRoleRefDTO  extends BaseDTO {

    private String  id;

    private int menuId;

    private int userRoleId;

    private String createName;
    private String createId;

    private Date createTime;

    private String updateId;
    private String updateName;

    private Date updateTime;

    public AuthRoleRef convertToAllocation(){
        AuthRoleRefConvert authRoleRefConvert = new AuthRoleRefConvert();
        return authRoleRefConvert.doForward(this);
    }

    private static class AuthRoleRefConvert extends BaseDtoConvert<AuthRoleRefDTO, AuthRoleRef>{
        @Override
        protected AuthRoleRef doForward(AuthRoleRefDTO authRoleRefDTO) {
            AuthRoleRef authRoleRef = new AuthRoleRef();
            BeanUtils.copyProperties(authRoleRefDTO, authRoleRef);
            return authRoleRef;
        }

        @Override
        protected AuthRoleRefDTO doBackward(AuthRoleRef authRoleRef) {
            return null;
        }
    }



}
