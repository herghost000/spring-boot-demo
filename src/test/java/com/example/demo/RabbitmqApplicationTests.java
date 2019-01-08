package com.example.demo;

import com.example.demo.beans.User;
import com.example.demo.sender.DirectSender;
import com.example.demo.sender.FanoutSender;
import com.example.demo.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;

    @Test
    public void testFanout() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("herghost");
        fanoutSender.send(user);
    }

    @Test
    public void testDirect() throws Exception {
        User user=new User();
        user.setId(1L);
        user.setUsername("zack addy");
        directSender.send(user);
    }

    @Test
    public void testTopic() throws Exception {
        User user=new User();
        user.setId(1L);
        user.setUsername("zack addy");
        topicSender.send(user);
    }
}
