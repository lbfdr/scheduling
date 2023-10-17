package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminAuth;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@ToString(callSuper = true)
public class AdminAuthDTO extends BaseDTO   {

    private String id;

    private String authName;

    private String level;

    private String pid;

    private String createName;
    private String createId;

    private Date createTime;

    private String updateId;
    private String updateName;

    private Date updateTime;

    private String state;

    public AdminAuth convertToAdminAuth(){
        AdminDtoConvert adminDtoConvert = new AdminDtoConvert();
        return adminDtoConvert.doForward(this);
    }

    private static class AdminDtoConvert extends BaseDtoConvert<AdminAuthDTO, AdminAuth>{
        @Override
        protected AdminAuth doForward(AdminAuthDTO adminAuthDTO) {
            AdminAuth adminAuth = new AdminAuth();
            //将给定源 bean 的属性值复制到目标 bean 中
            BeanUtils.copyProperties(adminAuthDTO, adminAuth);
            return adminAuth;
        }

        @Override
        protected AdminAuthDTO doBackward(AdminAuth adminAuth) {
            return null;
        }
    }



}

