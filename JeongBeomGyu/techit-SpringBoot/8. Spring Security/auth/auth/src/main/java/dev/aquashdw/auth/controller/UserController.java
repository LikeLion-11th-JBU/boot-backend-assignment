package dev.aquashdw.auth.controller;

import dev.aquashdw.auth.dto.UserDto;
import dev.aquashdw.auth.entity.UserEntity;
import dev.aquashdw.auth.entity.UserRepository;
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

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserController(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("login")
    public String login(){
        return "login-form";
    }

    @GetMapping("signup")
    public String signup(){
        return "signup-form";
    }

    @PostMapping("signup")
    public String signupPost(
            @RequestParam("username") String username,      // 사용자가 입력한 사용자의 이름을 받아온다.
            @RequestParam("password") String password,      // 사용자가 입력한 사용자의 패스워드를 받아온다.
            @RequestParam("password_check") String passwordCheck        // 사용자가 입력한 패스워드를 체크한다.
    ){
        if(!password.equals(passwordCheck)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = new UserEntity();      // password 가 일치할때
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
        return "redirect:/home";
    }
}
