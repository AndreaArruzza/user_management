package com.savemoney.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

    @GetMapping(value="/hello")
    public String hello(){
        return "Hello!";
    }
}
