package com.example.demo.netty.exception;

import java.io.Serializable;

/**
 * 参数错误异常
 */
public class ErrorParamsException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ErrorParamsException() {
        super();
    }

    public ErrorParamsException(String message) {
        super(message);
    }
}
