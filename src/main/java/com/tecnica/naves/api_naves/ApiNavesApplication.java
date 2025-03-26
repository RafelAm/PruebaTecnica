package com.tecnica.naves.api_naves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class ApiNavesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiNavesApplication.class, args);
    }
}
