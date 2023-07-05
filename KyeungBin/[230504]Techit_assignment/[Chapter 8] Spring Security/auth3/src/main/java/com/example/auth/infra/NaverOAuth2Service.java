package com.example.auth.infra;

import com.example.auth.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


@Service
public class NaverOAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
    private static final Logger logger = LoggerFactory.getLogger(NaverOAuth2Service.class);
    private final UserRepository userRepository;

    public NaverOAuth2Service(
            @Autowired UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String nameAttributeName = userRequest
                .getClientRegistration()
                // 현재 들어온 요청이 어떠한 registration 을 기준으로 들어온건지 묻는 것
                .getProviderDetails()
                // registration에 대한 동일한 provider에 대한 detail한 부분을 묻는 것
                .getUserInfoEndpoint()
                // user 정보를 어디서 받아오는지
                .getUserNameAttributeName();
                // ?? 요건 넘어가셧따 (질문 or 검색)

//        logger.info(oAuth2User.getAttributes().toString());
        Map<String, Object> attributeMap = oAuth2User.getAttributes();
        // 아 이건 또 어떻게 쓰는거지 (검색)
        Map<String, Object> responseMap = (Map<String, Object>) attributeMap.get("response");
        DefaultOAuth2User defaultOAuth2User = new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                (Map<String, Object>) responseMap, "email"
        );
        return defaultOAuth2User;
    }



}
