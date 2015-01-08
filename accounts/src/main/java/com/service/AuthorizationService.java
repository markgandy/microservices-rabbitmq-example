package com.service;

import com.amqp.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationService {

    @Autowired
    private Sender sender;

    public boolean isAuthorized() {
        String response = sender.sendAndReceive("authorized?");
        if (response.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

}
