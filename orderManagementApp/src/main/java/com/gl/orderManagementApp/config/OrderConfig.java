package com.gl.orderManagementApp.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Configuration
public class OrderConfig {

    private static final String baseUrl = "http://localhost:8086/registration";

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(baseUrl);
        return builder
                .uriTemplateHandler(uriTemplateHandler)
                .build();
    }

}
