package com.example.demo.config;

import com.example.demo.impl.HerGhost;
import com.example.demo.service.HerGhostImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public HerGhost herghost() {
        return new HerGhostImpl();
    }
}
