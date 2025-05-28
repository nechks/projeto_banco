package com.example.projeto_banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProjetoBancoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoBancoApplication.class, args);
        
    }

}
