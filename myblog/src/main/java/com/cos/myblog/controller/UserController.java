package com.cos.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//인증이 안된사용자들만 /auth가 붙어있는 경로만 허용
//그냥 주소가 / 이면 메인화면인 index로 갈수있도록 허용
//static 이하의 폴더는 허용

@Controller
public class UserController {

    @GetMapping("/auth/join")
    public String joinForm(){
        return "join";
    }

    @GetMapping("/auth/loginpage")
    public String loginForm(){
        return "loginpage";
    }


}
