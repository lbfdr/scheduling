package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.cn.topsroboteer.scheduling.administration.userManage.model.Allocation;
import com.cn.topsroboteer.scheduling.administration.userManage.model.Daily;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class DailyDTO extends BaseDTO {

    private String id;

    private String dateType;

    private Date dailyDate;

    private String content;

    private String duration;

    private String workType;

    private String projectId;
    private String projectName;

    private String taskId;
    private String taskName;

    private Date startDate;
    private Date endDate;

    private String userId;

    private String userName;



    public Daily convertToAllocation(){
        DailyConvert dailyConvert = new DailyConvert();
        return dailyConvert.doForward(this);
    }

    private static class DailyConvert extends BaseDtoConvert<DailyDTO, Daily>{
        @Override
        protected Daily doForward(DailyDTO dailyDTO) {
            Daily daily = new Daily();
            BeanUtils.copyProperties(dailyDTO, daily);
            return daily;
        }

        @Override
        protected DailyDTO doBackward(Daily daily) {
            return null;
        }
    }


}
