package com.example.auth.infra;
// user details => 영상 8-2 16분부터 다시 정리해보기

import com.example.auth.controller.AdminController;
import com.example.auth.entity.UserEntity;
import com.example.auth.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(
            CustomUserDetailsService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService (
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ){ // 복습 => 레포지토리가 어떻게 돌아가고 생성되는지 잘 모르는듯 왜자꾸 버벅거리지
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        final UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUsername("entity_user");
        testUserEntity.setPassword(passwordEncoder.encode("test1pass"));
        this.userRepository.save(testUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByUsername(username);
        return new User(username, userEntity.getPassword(), new ArrayList<>());
    }



}
