package com.cos.myblog.config.auth;

import com.cos.myblog.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//시큐리티가 로그인요청을 가로채서 로그인을 진행하교 완료가되면 UserDetails타입의 오브젝트를 principalDetail이란 시큐리티 고유저장
//소에 저장을 하는 것이다.
@Getter
public class PrincipalDetail implements UserDetails {
    private User user;

    public PrincipalDetail(User user){
        this.user = user; //이걸안해주면 우리가 회원가입한 아이디가아니라 그냥 시큐리티 기본아이디인 user와 비밀번호만 쓰게됨
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override //계정이 만료되었는지 판단
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //계정이 잠겨있는지 판단 위놈이랑 둘다 true라고 해야 만료안됨 안잠김
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override //비밀번호가 만료되었는지
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //계정이 사용가능인지 리턴
    public boolean isEnabled() {
        return true;
    }

    @Override //계정의 권한을 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();

        collectors.add(()->{return "ROLE_"+user.getRole();});

        return collectors;
    }
}
