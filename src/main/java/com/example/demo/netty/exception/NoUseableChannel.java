package com.example.demo.netty.exception;

import java.io.Serializable;

/**
 * 没有可用的通道异常
 */
public class NoUseableChannel extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public NoUseableChannel() {
        super();
    }

    public NoUseableChannel(String message) {
        super(message);
    }
}