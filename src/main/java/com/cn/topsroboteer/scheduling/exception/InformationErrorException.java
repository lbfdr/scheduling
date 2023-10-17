package com.cn.topsroboteer.scheduling.exception;

/**
 * @author Dong.w
 */
public class InformationErrorException extends RuntimeException {

    public InformationErrorException() {
        super("请求数据有误");
    }

    public InformationErrorException(String message) {
        super(message);
    }

}
