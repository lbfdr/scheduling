package com.cn.topsroboteer.scheduling.exception;

/**
 * @author Dong.w
 */
public class ForBiddenException extends RuntimeException {

    public ForBiddenException() {
        super("权限不足");
    }

}
