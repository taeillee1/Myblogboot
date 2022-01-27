package com.cos.myblog.controller;

import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import com.cos.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){ //@PathVariable -> url 경로에 변수를 넣어주기 위한것
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당유저는 없습니다 . id :" + id);
            }
        });
        return user;
    } //해당하는 id의 값이 db에 있으면 user의 정보를 리턴하고 아니라면 해당유저는 없습니다 라는 문구를 출력

    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("username :" + user.getUsername());
        System.out.println("password :" + user.getPassword());
        System.out.println("email :" + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/dummy/user")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user/page")
    public List<User> page(@PageableDefault(size = 1,sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users= pagingUser.getContent();
        return users;
    }

    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser ){
        System.out.println("id =" + id);
        System.out.println("password =" + requestUser.getPassword());
        System.out.println("email =" + requestUser.getEmail());
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        userRepository.save(user); //id를 전달하지 않으면 insert를 해주고 id를 전달하면 해당id의 데이터가 있으면 update를해준다
        //또한 id를 전달해도 해당 id가 없으면 insert를 해준다.

        return user;
    }

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            return "삭제에 실패하였습니다 해당 id는 DB에 없습니다";
        }
        return "삭제 되었습니다. id =" + id;
    }
}
