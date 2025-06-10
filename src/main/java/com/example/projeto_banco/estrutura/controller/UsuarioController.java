
package com.example.projeto_banco.estrutura.controller;

import com.example.projeto_banco.estrutura.model.UsuarioEntidy;
import com.example.projeto_banco.estrutura.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.mongodb.assertions.Assertions.assertNotNull;


@RequiredArgsConstructor
@Component
    public class UsuarioController implements CommandLineRunner {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Override
        public void run(String... args) {
            UsuarioEntidy user = new UsuarioEntidy("1","Yuri Martinelli","1234","125");
            UsuarioEntidy salvo = usuarioRepository.save(user);

            System.out.println("Usuario Salvo com sucesso" + salvo);

            assertNotNull(salvo);
        }



    }
