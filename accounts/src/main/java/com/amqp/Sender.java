package com.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Sender {

    private static final String DIRECT_REPLY_QUEUE = "direct.reply";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void setUpQueue() {
        this.amqpAdmin.declareQueue(new Queue(DIRECT_REPLY_QUEUE));
    }

    public String sendAndReceive(String message) {
        System.out.println("Sending message: " + message);
        return (String) rabbitTemplate.convertSendAndReceive(DIRECT_REPLY_QUEUE, message);
    }

}
