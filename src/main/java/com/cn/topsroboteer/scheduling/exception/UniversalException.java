package com.cn.topsroboteer.scheduling.exception;


import com.cn.topsroboteer.scheduling.utils.Constant;

/**
 * @author Dong.w
 */
public class UniversalException extends RuntimeException {

//    private ResultCodeType type;
    private Constant constant;

    public UniversalException(Constant type, String message) {
        super(message);
        this.constant = type;
    }

    public Constant getType() {
        return constant;
    }
}
