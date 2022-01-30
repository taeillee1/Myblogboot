package com.cos.myblog.config.auth;

import com.cos.myblog.model.User;
import com.cos.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                     return new UsernameNotFoundException("해당사용자를 찾을수 없습니다"+username);
                });
        return new PrincipalDetail(principal);//이것을 수행할 때 시큐리티 세션에 유저정보가 저장된다.
    }
}
