package dev.aquashdw.auth.config;

import dev.aquashdw.auth.infra.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;
    public WebSecurityConfig(@Autowired CustomUserDetailsService customUserDetailsService){
        userDetailsService = customUserDetailsService;
    }
    @Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
                .username("user1")
                .password("user1pass")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("admin1pass")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/home/**", "/user/signup/**")
                        .anonymous()
                        .anyRequest()
                        .authenticated())
                .formLogin(login->login
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/home")
                        .permitAll())
                .logout(logout->logout
                        .logoutUrl("user/logout")
                        .logoutSuccessUrl("/home")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .permitAll());
        return http.build();
    }


}
