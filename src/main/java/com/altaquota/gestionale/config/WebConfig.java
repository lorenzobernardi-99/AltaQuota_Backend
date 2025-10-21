package com.altaquota.gestionale.config;

import org.springframework.beans.factory.annotation.Value; // Importa Value
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Inietta il valore della variabile d'ambiente/properties
    @Value("${frontend.origin.url}")
    private String frontendOriginUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            // Usa la variabile!
            .allowedOrigins(frontendOriginUrl) 
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}