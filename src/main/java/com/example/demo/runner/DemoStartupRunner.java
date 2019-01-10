package com.example.demo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1) //例如1-10，优先级从高到低
public class DemoStartupRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("[CommandLineRunner] DemoStartupRunner run " + Arrays.asList(args));
    }
}
