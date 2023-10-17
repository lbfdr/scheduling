package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO基类
 *
 * @author Dong.w
 */
@Data
public class BaseDTO implements Serializable {

    @NotNull
    @Length(min = 32)//验证字符串是否在最小和最大包含范围之间。
    private String token;

    @Min(10000)//元素的值必须大于或等于指定的value值
    private Long uid;

}
