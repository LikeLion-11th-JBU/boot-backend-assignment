package com.sung.sungboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sung.sungboard.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SungBoard API Documentation")
                .description("게시판")
                .version("0.0.0")
                .build();
    }
    private springfox.documentation.spi.service.contexts.SecurityContext securityContext() {
        return springfox.documentation.spi.service.contexts.SecurityContext.builder()
                .build();
    }

    private SecurityScheme apiKey() {
        return null; // Replace null with the appropriate security scheme implementation
    }
}

