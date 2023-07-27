package jym.yeongmu.auth.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //의존성 설정을 적용 할 준비가 되어있다.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/home")
                .permitAll()
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
