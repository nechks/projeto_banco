package com.example.projeto_banco.estrutura.servis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.projeto_banco.estrutura.entidade.CursoEntidy;
import com.example.projeto_banco.estrutura.repository.CursoRepository;

@Service
public class CursoService {

 @Autowired
 private CursoRepository cursoRepository;

 @Cacheable(value = "curso", key = "#id")
 public Optional<CursoEntidy> buscarCursoPorId(String id) {
  System.out.println("Buscando no MongoDB...");
  return cursoRepository.findById(id);
 }
}
