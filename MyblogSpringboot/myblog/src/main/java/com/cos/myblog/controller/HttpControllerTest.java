package com.cos.myblog.controller;

import org.springframework.web.bind.annotation.*;

//사용자가 요청하면 응답(Data에 대한 응답)
//응답이 HTML파일로 되게 하고싶다면 @Controller로 하면된다
@RestController
public class HttpControllerTest {
    //get -> select post -> insert put -> update delete -> delete
    //인터넷 요청은 GetMapping으로만 가능하다.
    @GetMapping("/http/get")//RequesetParam으로 값을 받음
    public String getTest(@RequestParam int id, @RequestParam(required = false
    , defaultValue = "") String username){
        return "get 요청 : " +id +"," + username;
    }
    @PostMapping("/http/post")//RequestBody로 값을 받음
    public String postTest(@RequestBody String text){
        return "post 요청"+text;
    }
    @PutMapping("/http/put")
    public String putTest(){
        return "put 요청";
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }

}
