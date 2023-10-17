package com.cn.topsroboteer.scheduling.administration.userManage.model.dto;

/**
 * DTO转化接口
 *
 * @author Dong.w
 */
public abstract class BaseDtoConvert<D, T> {

    /**
     * 将DTO转化未实体
     * @param d DTO
     * @return  实体
     */
    protected abstract T doForward(D d);

    /**
     * 将实体转化未DTO
     * @param t 实体
     * @return  DTO
     */
    protected abstract D doBackward(T t);
}
