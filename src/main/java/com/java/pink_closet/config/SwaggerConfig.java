package com.java.pink_closet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pinkClosetOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pink Closet API")
                        .description("API for managing Pink Closet store operations.")
                        .version("1.0.0"));
    }
}
