package com.example.projeto_banco.estrutura.repository;

import com.example.projeto_banco.estrutura.entidade.TurmaEntidy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurmaReposity extends MongoRepository<TurmaEntidy, String> {
}
