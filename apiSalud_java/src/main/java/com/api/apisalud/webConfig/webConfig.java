package com.api.apisalud.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/paciente") // Endpoint al que deseas permitir el acceso CORS
                .allowedOrigins("http://localhost:4200") // Origenes permitidos, en este caso, tu cliente Angular en el puerto 4200
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*"); // Headers permitidos, puedes personalizarlos según tus necesidades
    }
}
