package com.yourorganization.testtask.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library API")
                        .description("API для работы с книгами, клиентами и т.д.")
                        .version("1.0.0"));
    }

    /**
     * Если хотим сгруппировать эндпоинты по v1, v2 и т.п.
     */
    @Bean
    public GroupedOpenApi apiV1() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/api/v1/**")
                .build();
    }
    @Bean
    public GroupedOpenApi clientApi() {
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/api/v2/**")
                .build();
    }

    @Bean
    public GroupedOpenApi borrowApi() {
        return GroupedOpenApi.builder()
                .group("v3")
                .pathsToMatch("/api/v3/**")
                .build();
    }

}
