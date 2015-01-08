package com.amqp;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationListener {
    public String handleMessage(String message) {
        System.out.println("Replying to '" + message + "' with 'yes'");
        return "yes";
    }
}
