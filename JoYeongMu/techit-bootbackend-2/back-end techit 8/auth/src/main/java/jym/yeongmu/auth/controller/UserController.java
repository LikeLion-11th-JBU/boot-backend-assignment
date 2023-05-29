package jym.yeongmu.auth.controller;

import jym.yeongmu.auth.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("login")
    public String login() {
        return "login-form";
    }

    @GetMapping("sign-up")
    public String signup() {
        return "signup-form";
    }

    @PostMapping("signup")
    public String signupPost(){
        return "redirect:/home";
    }
}
