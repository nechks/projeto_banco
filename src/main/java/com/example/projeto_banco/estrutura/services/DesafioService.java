package com.example.projeto_banco.estrutura.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto_banco.estrutura.model.DesafioEntidy;
import com.example.projeto_banco.estrutura.repository.DesafioRepository;

@Service
public class DesafioService {
 Scanner scanner = new Scanner(System.in);
 @Autowired
 private DesafioRepository desafioRepository;

 public void adicionarDesafio() {

  System.out.println("Digite o ID do desafio:");
  String id = scanner.nextLine(); // ← Aqui o ID será, por exemplo, "1"

  System.out.println("Digite o nome do curso:");
  String curso = scanner.nextLine();

  System.out.println("Digite o nome do período:");
  String periodo = scanner.nextLine();

  System.out.println("Digite o nome da turma:");
  String turma = scanner.nextLine();

  System.out.println("Quantos alunos deseja adicionar?");
  int qtdAlunos = Integer.parseInt(scanner.nextLine());

  List<String> listaAlunos = new ArrayList<>();

  for (int i = 0; i < qtdAlunos; i++) {
   System.out.println("Digite o nome do aluno " + (i + 1) + ":");
   String aluno = scanner.nextLine();
   listaAlunos.add(aluno);
  }

  DesafioEntidy desafio = DesafioEntidy.builder()
    .id(id) // ← ID definido manualmente
    .curso(curso)
    .periodo(periodo)
    .turma(turma)
    .alunos(listaAlunos)
    .build();

  desafioRepository.save(desafio);
  System.out.println("Desafio salvo com ID: " + id);
 }

 public List<DesafioEntidy> listarTodos() {
  return desafioRepository.findAll();
 }

 public void buscarPorId(String id) {
  Optional<DesafioEntidy> desafio = desafioRepository.findById(id.trim());

  if (desafio.isPresent()) {
      DesafioEntidy d = desafio.get();
      System.out.println("Desafio encontrado:");
      System.out.println("Curso: " + d.getCurso());
      System.out.println("Período: " + d.getPeriodo());
      System.out.println("Turma: " + d.getTurma());
      System.out.println("Alunos: " + d.getAlunos());
  } else {
      System.out.println("Desafio com ID '" + id + "' não encontrado.");
  }
}


 public DesafioEntidy atualizar(String id, DesafioEntidy dadosAtualizados) {
  DesafioEntidy desafio = desafioRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));

  desafio.setCurso(dadosAtualizados.getCurso());
  desafio.setPeriodo(dadosAtualizados.getPeriodo());
  desafio.setTurma(dadosAtualizados.getTurma());
  desafio.setAlunos(dadosAtualizados.getAlunos());

  return desafioRepository.save(desafio);
 }

 public void deletar(String id) {
  desafioRepository.deleteById(id);
 }

}
