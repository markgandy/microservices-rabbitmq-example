package com;

import com.amqp.AuthorizationListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final String DIRECT_REPLY_QUEUE = "direct.reply";

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private AuthorizationListener authorizationListener;

    @Bean
    public SimpleMessageListenerContainer serviceListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(requestQueue());
        container.setMessageListener(new MessageListenerAdapter(authorizationListener));
        return container;
    }

    @Bean
    public Queue requestQueue() {
        return new Queue(DIRECT_REPLY_QUEUE);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
