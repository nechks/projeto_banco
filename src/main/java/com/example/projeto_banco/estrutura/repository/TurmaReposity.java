package com.example.projeto_banco.estrutura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.projeto_banco.estrutura.model.TurmaEntidy;

public interface TurmaReposity extends MongoRepository<TurmaEntidy, String> {
}
