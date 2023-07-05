package com.example.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// 의존성 spring security를 사용할 준비가 됐다는 것을 알려줌.

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // AuthorizationConfigurer 를 받는 줄

                .antMatchers("/home/**", "/user/**")
                // 질문 ** 의 쓰임새? -> 잘 안들림.. ( 특정 url 에 대한 요청 ? )
                // anyRequest() : url 기반의 권한 확인기법 (언제 허용을 하고 언제 비허용을 할 것인지)
                // antMAtchers() : url mapping 담당

                .anonymous()
                // anonymous() : 익명의 사용자들이 접근할 수 있도록 해주는 것 (로그인을 할 수 있도록)
                // authenticated() : 로그인을 한 사용자가 접근하는 것
                // permitall() : 로그인과 관계 없이 누구든지 접속가능하게 하는 것

                .anyRequest()
                //            

                .authenticated()
                // admin의 경로로 들어가는 경우에는 인증요구

             .and()
                // and()를 사용함으로써 authroizeRequests 는 끝나고 httpSecurity 를 다시 받아왔다고 판단 가능
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/admin")
                .permitAll()
                // 마지막에는 permitAll을 해주는게 좋다!

             .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSEESIONID")
                .invalidateHttpSession(true)
                .permitAll()




        ;
    }


}
