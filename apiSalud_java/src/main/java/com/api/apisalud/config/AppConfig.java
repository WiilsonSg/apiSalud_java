package com.api.apisalud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com.api.apisalud")
public class AppConfig {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();

    }
}
