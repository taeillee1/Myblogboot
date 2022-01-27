package com.cos.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

}
