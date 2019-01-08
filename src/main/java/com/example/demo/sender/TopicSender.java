package com.example.demo.sender;

import com.example.demo.beans.User;
import com.example.demo.config.RabbitConfiguration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 第一个参数：TopicExchange名字
    // 第二个参数：Route-Key
    // 第三个参数：要发送的内容
    public void send(User user) throws InterruptedException {
        this.rabbitTemplate.convertAndSend(RabbitConfiguration.TOPIC_EXCHANGE,"lzc.message", user);
        Thread.sleep(1000);
        this.rabbitTemplate.convertAndSend(RabbitConfiguration.TOPIC_EXCHANGE, "lzc.lzc", user);
    }
}
