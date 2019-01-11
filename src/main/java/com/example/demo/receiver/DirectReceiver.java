package com.example.demo.receiver;

import com.example.demo.beans.User;
import com.example.demo.config.RabbitConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class DirectReceiver {
    @RabbitListener(queues = RabbitConfiguration.DIRECT_QUEUE1)
    public void receiveDirect1(User user) {

        System.out.println("【receiveDirect1监听到消息】" + user);
    }

    @RabbitListener(queues = RabbitConfiguration.DIRECT_QUEUE2)
    public void receiveDirect2(User user) {

        System.out.println("【receiveDirect2监听到消息】" + user);
    }

}
