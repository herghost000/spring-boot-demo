package com.example.demo.sender;


import com.example.demo.beans.User;
import com.example.demo.config.RabbitConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {
        this.rabbitTemplate.convertAndSend(RabbitConfiguration.DIRECT_EXCHANGE, "direct.pwl", user);
    }
}
