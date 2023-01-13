package com.example.teste6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class RickyAndMortyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RickyAndMortyBackendApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public HttpHeaders httpHeaders (){
        return new HttpHeaders();
    }
}
