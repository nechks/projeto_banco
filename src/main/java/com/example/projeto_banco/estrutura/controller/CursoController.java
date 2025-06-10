package com.example.projeto_banco.estrutura.controller;

import com.example.projeto_banco.estrutura.services.CursoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CursoController implements CommandLineRunner {

    
    @Autowired
    private CursoService cursoService;

    @Override
    public void run(String... args) {
        //cursoService.adicionarCurso();
        cursoService.listarTodos();

    }

}

