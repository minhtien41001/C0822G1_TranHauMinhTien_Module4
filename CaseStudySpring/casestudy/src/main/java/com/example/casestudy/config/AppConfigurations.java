package com.example.casestudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfigurations implements WebMvcConfigurer {

    private static final String[] PATHS = {
            "classpath:/static/bootstrap/bootstrap-5.1.3"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(PATHS);
    }
}
