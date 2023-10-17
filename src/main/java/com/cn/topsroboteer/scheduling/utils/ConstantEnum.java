package com.cn.topsroboteer.scheduling.utils;

/**
 * 常量枚举
 * @author Dong.w
 */
public enum ConstantEnum {

    /**
     * 加密——盐值
     */
    ENCRYPTION_KEY("jxzy-bigPad");

    private Object value;

    ConstantEnum(Object value){
        this.value = value;
    }

    public Object getValue(){
        return value;
    }
}
