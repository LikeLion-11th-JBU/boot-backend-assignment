package com.example.auth.controller;

import com.example.auth.config.PasswordEncoderConfig;
import com.example.auth.dto.UserDto;
import com.example.auth.entity.UserEntity;
import com.example.auth.entity.UserRepository;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(
            AdminController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("login")
    public String login(){
        return "login-form";
    }

    @GetMapping("signup")
    public String signUp(){
        return "signup-form";
    }

    @PostMapping("signup")
    public String signUpPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck
    ){
        if (password.equals(passwordCheck)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode("password"));
        userRepository.save(newUser);

        return "redirect:/home";
        // (질문) 왜 홈으로 안 돌아오지??

    }

}
