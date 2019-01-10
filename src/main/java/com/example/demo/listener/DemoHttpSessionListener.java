package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DemoHttpSessionListener implements HttpSessionListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("[Session] 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("[Session] 销毁");
    }
}
