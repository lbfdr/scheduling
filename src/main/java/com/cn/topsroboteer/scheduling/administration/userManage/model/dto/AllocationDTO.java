package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.AdminUser;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class AllocationDTO extends BaseDTO {

    private String id;

    private String taskId;

    private String taskName;

    private String handlerId;

    private String handlerName;

    private Date estimateDate;

    public Allocation convertToAllocation(){
        AllocationConvert allocationConvert = new AllocationConvert();
        return allocationConvert.doForward(this);
    }

    private static class AllocationConvert extends BaseDtoConvert<AllocationDTO, Allocation>{
        @Override
        protected Allocation doForward(AllocationDTO allocationDTO) {
            Allocation allocation = new Allocation();
            BeanUtils.copyProperties(allocationDTO, allocation);
            return allocation;
        }

        @Override
        protected AllocationDTO doBackward(Allocation allocation) {
            return null;
        }
    }




}
