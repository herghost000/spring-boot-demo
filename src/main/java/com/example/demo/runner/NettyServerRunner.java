package com.example.demo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * https://github.com/marquisXuan/netty/blob/master/spring-boot-netty/netty-demo/netty-server/src/main/java/org/yyx/netty/server/dispatcher/RequestDispatcher.java
 */
@Component
public class NettyServerRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Resource
//    private NettyServerListener nettyServerListener;

    @Override
    public void run(String... args) throws Exception {

    }
}

