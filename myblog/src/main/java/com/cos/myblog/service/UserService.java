package com.cos.myblog.service;

import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import com.cos.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해준다 ->Ioc를 해준다는 뜻
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional //아래의 save함수를 하나의 트렌젝션으로 취급하고 여러개중 하나라도 실패시 롤백
    public void save(User user){
        String rawPassword = user.getPassword(); //비밀번호 원문
        String encPassword = encoder.encode(rawPassword); //해쉬화한 비밀번호
        user.setPassword(encPassword);
        user.setEmail(user.getEmail());
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    @Transactional
    public void userUpdate(User user){
        User persistence = userRepository.findById(user.getId()).orElseThrow(()->{
           return new IllegalArgumentException("회원찾기 실패");
        });
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        persistence.setPassword(encPassword);
        persistence.setEmail(user.getEmail());
    }

//    @Transactional(readOnly = true)//readOnly = true 라고 하면 트랜젝션 시작에서 종료까지의 정합성을 유지시켜준다
//    public User login(User user){
//
//        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//    }
}
