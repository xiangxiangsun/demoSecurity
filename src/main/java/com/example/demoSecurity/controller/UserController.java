package com.example.demoSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String getUsers(){
        return "Hello Spring Security";
    }
}
