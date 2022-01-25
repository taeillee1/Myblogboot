package com.cos.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/test/hello")
    public String index(){

        return "<h1>hello spring boot</h1>";
    }
}
