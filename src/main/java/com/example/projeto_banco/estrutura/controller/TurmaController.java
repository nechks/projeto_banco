
package com.example.projeto_banco.estrutura.controller;

import com.example.projeto_banco.estrutura.entidade.TurmaEntidy;
import com.example.projeto_banco.estrutura.repository.TurmaReposity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.mongodb.assertions.Assertions.assertNotNull;


@RequiredArgsConstructor
@Component
public class TurmaController implements CommandLineRunner {

    @Autowired
    private TurmaReposity turmaReposity;

    @Override
    public void run(String... args) {
        TurmaEntidy turma = new TurmaEntidy("1","125");

        TurmaEntidy salvo = turmaReposity.save(turma);
        assertNotNull(salvo);
        System.out.println("Usuário turma: " + salvo);

    }

}


