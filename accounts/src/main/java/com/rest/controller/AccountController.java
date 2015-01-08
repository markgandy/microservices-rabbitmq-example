package com.rest.controller;

import com.domain.Account;
import com.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getAccounts() {
        if (authorizationService.isAuthorized()) {
            Account account = new Account();
            account.setAccountNumber("12345678");
            return account;
        }
        return null;
    }

}
