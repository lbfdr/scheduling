package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Department;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class DepartmentDTO extends BaseDTO {

    private String id;

    private String departmentName;

    private String sort;

    private Date createTime;

    private Date updateTime;

    private String isDel;


    public Department convertToAllocation(){
        DepartmentConvert departmentConvert = new DepartmentConvert();
        return departmentConvert.doForward(this);
    }

    private static class DepartmentConvert extends BaseDtoConvert<DepartmentDTO, Department>{
        @Override
        protected Department doForward(DepartmentDTO departmentDTO) {
            Department department = new Department();
            BeanUtils.copyProperties(departmentDTO, department);
            return department;
        }

        @Override
        protected DepartmentDTO doBackward(Department department) {
            return null;
        }
    }




}
