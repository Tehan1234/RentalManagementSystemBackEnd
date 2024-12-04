package org.icet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Config {

    @Bean
    public ModelMapper getModalMapper() {
        return new ModelMapper();
    }


}
