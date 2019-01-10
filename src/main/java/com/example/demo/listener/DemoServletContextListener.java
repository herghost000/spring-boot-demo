package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DemoServletContextListener implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("[ServletContex] 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("[ServletContex] 销毁");
    }
}
