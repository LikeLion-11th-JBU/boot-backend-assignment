package com.board.crudboard.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger springdoc-ui 구성 파일
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("CRUD 게시판")
                .version("v1.6.14")
                .description("Swagger 연습용 게시판 구현입니다.");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
