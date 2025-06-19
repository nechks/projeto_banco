package com.example.projeto_banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.projeto_banco.estrutura.services.DesafioService;

@SpringBootApplication
public class ProjetoBancoApplication {

    public static void main(String[] args) {
        // Cria o contexto do Spring
        ConfigurableApplicationContext context = SpringApplication.run(ProjetoBancoApplication.class, args);

        // Recupera o bean gerenciado
        DesafioService desafioService = context.getBean(DesafioService.class);


        // Executa o método
        //desafioService.adicionarDesafio();
        desafioService.buscarPorId("1");
    }
}

