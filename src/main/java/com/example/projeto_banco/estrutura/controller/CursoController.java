package com.example.projeto_banco.estrutura.controller;

import com.example.projeto_banco.estrutura.entidade.CursoEntidy;
import com.example.projeto_banco.estrutura.repository.CursoRepository;
import com.example.projeto_banco.estrutura.servis.CursoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.mongodb.assertions.Assertions.assertNotNull;


@RequiredArgsConstructor
@Component
public class CursoController implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;

    @Override
    public void run(String... args) {
        CursoEntidy curso = new CursoEntidy("1","Sistema da informacao");
        CursoEntidy curso2 = new CursoEntidy("2","Analise e desenvolvimento de sistemas");

        CursoEntidy salvo = cursoRepository.save(curso);
        assertNotNull(salvo);
        System.out.println("Salvo com sucesso" + salvo);
        salvo = cursoRepository.save(curso2);
        assertNotNull(salvo);
        System.out.println("Salvo com sucesso" + salvo);

        cursoService.buscarCursoPorId("1");
        cursoService.buscarCursoPorId("1");
        cursoService.buscarCursoPorId("1");

    }

}

