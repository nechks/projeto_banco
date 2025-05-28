package com.example.projeto_banco.estrutura.repository;

import com.example.projeto_banco.estrutura.entidade.PeriodoEntidy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeriodoRepository extends MongoRepository<PeriodoEntidy, String> {
}
