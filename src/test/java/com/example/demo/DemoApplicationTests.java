package com.example.demo;

import com.example.demo.controller.GreetingController;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GreetingController.class)
@EnableAutoConfiguration
public class DemoApplicationTests {

    @Autowired
    private GreetingController greetingController;

    @Test
    public void contextLoads() {
        TestCase.assertNotNull(greetingController.greeting(""));
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        // redis存储数据
        User u = new User();
        u.setUsername("haha");
        redisTemplate.opsForValue().set("test:set1", "x");
        System.out.println(redisTemplate.opsForValue().get("user.cc"));
    }
}

