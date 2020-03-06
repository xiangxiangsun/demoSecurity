package com.example.demoSecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }

    @RequestMapping("/index")
    public String userIndex(){
        return "index";
    }

    @RequestMapping("/loginError")
    public String loginError(){
        return "loginError";
    }

    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
