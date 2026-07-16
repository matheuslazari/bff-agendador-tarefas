package com.matheus.bffagendadortarefas.infraestructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConflict {

    @Bean
    public FeignError feignError(){
        return new FeignError();
    }
}
