package com.example.projeto_banco.estrutura.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.projeto_banco.estrutura.entidade.UsuarioEntidy;
import com.example.projeto_banco.estrutura.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testInserirUsuario() {
        UsuarioEntidy usuario = new UsuarioEntidy("2","Yuri_","3344_","125_");


        UsuarioEntidy salvo = usuarioRepository.save(usuario);

        assertNotNull(salvo.getId());  // Verifica se foi salvo corretamente
        System.out.println("Usuário salvo: " + salvo);
    }
}
