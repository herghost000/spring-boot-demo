package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyConfiguration {
    @Value("${netty.boss.thread.count}")
    private int bossCount;

    @Value("${netty.worker.thread.count}")
    private int workerCount;

    @Value("${netty.tcp.port}")
    private int tcpPort;

    @Value("${netty.socket.keepalive}")
    private boolean keepAlive;

    @Value("${netty.socket.backlog}")
    private int backlog;

}
