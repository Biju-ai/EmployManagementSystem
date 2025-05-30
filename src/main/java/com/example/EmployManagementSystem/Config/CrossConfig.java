package com.example.EmployManagementSystem.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // allow all paths
                        .allowedOrigins("http://localhost:3000") // allow specific origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // allowed HTTP methods
                        .allowedHeaders("*") // allow all headers
                        .allowCredentials(true); // allow cookies
            }
        };
    }
}