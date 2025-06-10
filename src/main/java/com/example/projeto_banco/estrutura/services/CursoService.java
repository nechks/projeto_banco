package com.example.projeto_banco.estrutura.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.projeto_banco.estrutura.model.CursoEntidy;
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

 public void adicionarCurso(){
  Scanner scanner = new Scanner(System.in);

  System.out.println("Digite o nome do Curso");
  String nameCurso = scanner.nextLine();
  
 

  CursoEntidy cEntidy = CursoEntidy.builder()
  .curso(nameCurso).build();

  cursoRepository.save(cEntidy);
  scanner.close();

  
 }

 public CursoEntidy buscarPorId(String id) {
  return cursoRepository.findById(id).orElse(null);
 }

 public List <CursoEntidy> listarTodos(){
  return cursoRepository.findAll();
 }

 public CursoEntidy atualizar(String id, CursoEntidy dadosAtulizadados){
  CursoEntidy curso = cursoRepository.findById(id)
   .orElseThrow(() -> new RuntimeException("Curso nao encontrado"));

   curso.setCurso(dadosAtulizadados.getCurso());
   curso.setId(dadosAtulizadados.getId());

   return cursoRepository.save(curso);
 }


 public void deletar(String id){
  cursoRepository.deleteById(id);
 }




}
