package de.htwberlin.webtech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Webconfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("*")
                .allowedOrigins("http://localhost:3000", "http://localhost:8080", "http://localhost:3001", "https://vokabeln-frontend.herokuapp.com/")
                .allowedMethods("*");
    }

}

