package com.cos.myblog.controller.api;

import com.cos.myblog.dto.ResponseDto;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import com.cos.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/api/user") //여기서 return 된값이 js에 resp로 들어가는것
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("save 호출됨");
        //여기서 DB에 insert를하고 return 하면 js에서 ajax done 부분에 들어간다
        user.setRole(RoleType.USER);
        userService.save(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1); //Ok부분에 정상적으로 출력되면 200이 들어간다
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user){
        System.out.println("login 호출됨");
        User principal = userService.login(user);
        if(principal!=null){
            session.setAttribute("principal",principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
}
