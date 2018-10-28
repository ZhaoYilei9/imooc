package com.imooc.config;

import org.n3r.idworker.Sid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Sid getBean(){
        Sid sid = new Sid();
        return sid;
    }
}
