package com.example.projeto_banco.estrutura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.projeto_banco.estrutura.model.PeriodoEntidy;

public interface PeriodoRepository extends MongoRepository<PeriodoEntidy, String> {
}
