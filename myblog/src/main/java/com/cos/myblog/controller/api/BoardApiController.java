package com.cos.myblog.controller.api;

import com.cos.myblog.config.auth.PrincipalDetail;
import com.cos.myblog.dto.ResponseDto;
import com.cos.myblog.model.Board;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import com.cos.myblog.service.BoardService;
import com.cos.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board") //여기서 return 된값이 js에 resp로 들어가는것
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.write(board,principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1); //Ok부분에 정상적으로 출력되면 200이 들어간다
    }

//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user){
//        User principal = userService.login(user);
//        if(principal!=null){
//            session.setAttribute("principal",principal);
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//    }

}
