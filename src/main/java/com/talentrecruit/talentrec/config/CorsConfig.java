package com.talentrecruit.talentrec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class CorsConfig {
    public CorsConfig(){}
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration config=new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.setMaxAge(1800L);
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**",config);
        System.out.println(111111111);
        return new CorsFilter(source);
    }
}

