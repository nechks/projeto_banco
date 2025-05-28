package com.example.projeto_banco.estrutura.controller;

import com.example.projeto_banco.estrutura.entidade.PeriodoEntidy;
import com.example.projeto_banco.estrutura.repository.PeriodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.mongodb.assertions.Assertions.assertNotNull;


@RequiredArgsConstructor
@Component
public class PeriodoController implements CommandLineRunner {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public void run(String... args) {
        PeriodoEntidy periodo= new PeriodoEntidy("1","2023/1");
        PeriodoEntidy salvo = periodoRepository.save(periodo);
        assertNotNull(salvo);
        System.out.println("Periodo salvo com sucesso" + salvo);
    }

}

