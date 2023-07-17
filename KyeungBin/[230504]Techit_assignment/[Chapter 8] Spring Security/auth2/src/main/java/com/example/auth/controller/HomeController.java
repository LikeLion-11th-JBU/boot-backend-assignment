package com.example.auth.controller;

import com.example.auth.infra.AuthenticationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationFacade authFacade;

    public HomeController(
            @Autowired AuthenticationFacade authFacade) {
        this.authFacade = authFacade;
    }

            //Principal principal) { // 개인이나 업체의 로그인 아이디를 판단하기 위한 인터페이스
        // principal 대신 Authentication authentication 도 사용 가능하다
        // => 여러가지 로그인 방식에 따라서도 작동한다

        // SecurityContextholder.getContext(); 
        // => 현재 thread에 연관되어있는 정보는 security context에 저장된다
        // holder라는 class 안에 있는 static 메서드를 통해서 해당하는 context를 가져올 수 있다
        @GetMapping
        public String home(){

        try { // 질문  왜 anonymousUser밖에 안 뜰까...
            logger.info("connected user: {}", authFacade.getUserName());  // (~, SecurityContextholder.getContext.getAuthentication().getName());
        } catch (NullPointerException e) {
            logger.info("no user logged in");
        }
        return "index";
    }

}
