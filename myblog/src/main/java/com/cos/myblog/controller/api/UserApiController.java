package com.cos.myblog.controller.api;

import com.cos.myblog.dto.ResponseDto;
import com.cos.myblog.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("save 호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK,1); //Ok부분에 정상적으로 출력되면 200이 들어간다
    }
}
