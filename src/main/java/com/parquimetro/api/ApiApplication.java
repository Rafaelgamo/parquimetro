package com.parquimetro.api;


import com.parquimetro.api.infra.config.DocumentedAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ApiApplication implements DocumentedAPI {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
