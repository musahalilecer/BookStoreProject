package com.musahalilecer.bookstoreproject.total.webcross;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm endpointler için CORS aç
                .allowedOrigins("http://localhost:5173") // React için izin ver
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Tüm HTTP metotlarına izin ver
                .allowedHeaders("*") // Tüm header'lara izin ver
                .allowCredentials(true);
    }
}
