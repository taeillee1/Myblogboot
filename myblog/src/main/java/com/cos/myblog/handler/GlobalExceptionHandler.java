package com.cos.myblog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice//어디서든 Exception이 발생하면 이 handler로 오게하기위한 어노테이션
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleArgumentException(Exception e){
        return "<h1>"+e.getMessage()+"</h1>";
    }
}
