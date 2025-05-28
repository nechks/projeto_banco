package com.example.projeto_banco.estrutura.repository;

import com.example.projeto_banco.estrutura.entidade.UsuarioEntidy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository <UsuarioEntidy, String>{

}
