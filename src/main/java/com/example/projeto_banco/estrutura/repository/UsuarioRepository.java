package com.example.projeto_banco.estrutura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.projeto_banco.estrutura.model.UsuarioEntidy;

public interface UsuarioRepository extends MongoRepository <UsuarioEntidy, String>{

}
