package com.cos.myblog.config;

import com.cos.myblog.config.auth.PrincipalDetail;
import com.cos.myblog.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

//bean 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration//빈등록(IOC 관리)
@EnableWebSecurity//시큐리티 필터 추가
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크한다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailureHandler customFailurHandler;

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean//bean이 되면 함수의 return 값을 spring이 관리한다
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//csrf 토큰 비활성화 (테스트 시에는 해놓는게 좋다)
                .authorizeRequests()
                .antMatchers("/","/auth/**","/js/**","/css/**","/image/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/loginpage")//만약 인증이 필요하다면 로그인을 하게되고
                .loginProcessingUrl("/auth/loginProc")//요청오는 로그인을 가로채서 대신 로그인해준다
                .failureHandler(customFailurHandler)
                .defaultSuccessUrl("/"); //로그인에 성공하면 가는 곳

    }
}