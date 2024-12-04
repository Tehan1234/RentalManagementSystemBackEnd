package org.icet.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Config {

    public ModelMapper getModalMapper() {
        return new ModelMapper();
    }


}
