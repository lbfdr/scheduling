package com.cn.topsroboteer.scheduling.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 封装分页数据（记录数和所有记录）
 * @ProjectName: IDEA-CODE
 * @Package: com.hna.hka.archive.management.system.util
 * @ClassName: PageDataResult
 * @Author: 郭凯
 * @Description:
 * @Date: 2020/5/12 14:54
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDataResult {

    private Integer code=200;

    //总记录数量
    private Integer totals;

    private List<?> list;

    private List<?> data;

    private Integer count;

    public PageDataResult(Integer totals, List<?> data) {
        this.totals = totals;
        this.data = data;
    }
}
