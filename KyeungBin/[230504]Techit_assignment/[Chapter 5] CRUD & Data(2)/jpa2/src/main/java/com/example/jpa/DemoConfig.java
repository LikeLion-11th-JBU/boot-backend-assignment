package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
// 자신이 Bean을 제공하고 여러 설정들을 저장하기 위한 Annotation
// => 이 Annotation이 붙은 class는 스프링부트에서 활용할 설정들, Bean 들을
// 만들 수 있는 class라는 것을 Spring IOC에 알림
public class DemoConfig{
    private static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    @Value("${custom.property.single}")
    private String customProperty;
    // Value에 있는 값들이 설정되어있는 값에 찾아들어감. (application.yml참조)
    // Value 안에 있는 변수(customProperty)에 들어가게 될 것이란 의미

    @Value("${custom.property.comlist}")
    private List<String> customCommaList;
    //

    @Value("${custom.property.default:default-property}")
    private String propertyDefault;
    //

    @PostConstruct
    public void init(){
        logger.info("custom property: {}", customProperty);

        for (String commaListItem: customCommaList){
            logger.info("comma list item: {}", commaListItem);
        }
        logger.info("default property: {}", propertyDefault);
    }

    @Bean
    public Gson gson(){
        return new Gson();
        // 이 함수의 결과로 나타나게 되는 Gson의 결과값이
        // Spring IOC의 컨테이너의 관리 하에 들어가게 됨
        // 즉, DemoConfig에 있는 함수의 결과가 IOC 컨테이너에 존재하고
        // Autowired를 통해 가져올 수 있게 된다.
    }



}