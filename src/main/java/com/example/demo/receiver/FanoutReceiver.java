package com.example.demo.receiver;

import com.example.demo.beans.User;
import com.example.demo.config.RabbitConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfiguration.FANOUT_QUEUE1)
    public void receiveTopic1(User user) {
        System.out.println("【receiveFanout1监听到消息】" + user);
    }

    @RabbitListener(queues = RabbitConfiguration.FANOUT_QUEUE2)
    public void receiveTopic2(User user) {
        System.out.println("【receiveFanout2监听到消息】" + user);
    }
}
