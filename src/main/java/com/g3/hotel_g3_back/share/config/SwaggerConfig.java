package com.g3.hotel_g3_back.share.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI HOTEL_G3() {
        return new OpenAPI()
                .info(new Info()
                        .title("HOTEL-G3")
                        .description("hotel-g3")
                        .version("v1.0.0"));
    }
}
