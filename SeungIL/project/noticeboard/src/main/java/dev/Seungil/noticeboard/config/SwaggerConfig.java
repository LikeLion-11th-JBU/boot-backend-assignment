package dev.Seungil.noticeboard.config;

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
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.Seungil.noticeboard.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Board API Documentation")
                .description("게시판")
                .version("0.0.1")
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

