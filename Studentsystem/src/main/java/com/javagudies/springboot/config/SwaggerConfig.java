package com.javagudies.springboot.config;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("CRUD Operation") // Ensure this matches the group name you want
                .packagesToScan("com.javagudies.springboot") // Adjust this package as needed
                .pathsToMatch("/**") // Match all paths to include all endpoints
                .build();
    }
}
