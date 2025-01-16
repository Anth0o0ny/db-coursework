package com.anth0o0ny.backend.config;

import com.anth0o0ny.backend.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(Constants.ALL_PATHS)
                .allowedMethods(Constants.ALL_HTTP_METHODS);
    }

}
