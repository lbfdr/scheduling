package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Map;

/**
 * 删除信息接收数据
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseDataDTO extends BaseDTO {

    @Max(Long.MAX_VALUE)
    @Min(1)
    private String id;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;




}
