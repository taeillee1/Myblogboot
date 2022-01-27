package com.cos.myblog.service;

import com.cos.myblog.model.User;
import com.cos.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해준다 ->Ioc를 해준다는 뜻
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional //아래의 save함수를 하나의 트렌젝션으로 취급하고 여러개중 하나라도 실패시 롤백
    public void save(User user){

        userRepository.save(user);
    }

    @Transactional(readOnly = true)//readOnly = true 라고 하면 트랜젝션 시작에서 종료까지의 정합성을 유지시켜준다
    public User login(User user){

        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
