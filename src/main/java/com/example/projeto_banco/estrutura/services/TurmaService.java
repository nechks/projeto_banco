package com.example.projeto_banco.estrutura.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.example.projeto_banco.estrutura.model.TurmaEntidy;
import com.example.projeto_banco.estrutura.repository.TurmaReposity;

public class TurmaService {
 @Autowired
 private TurmaReposity turmaRepository;

 @Cacheable(value = "turma", key = "#id")
 public Optional<TurmaEntidy> buscarTurmaPorId(String id) {
  System.out.println("Buscando no MongoDB...");
  return turmaRepository.findById(id);
 }

 public void adicionarTurma() {
  Scanner scanner = new Scanner(System.in);

  System.out.println("Digite a turma");
  String nameTurma = scanner.nextLine();

  TurmaEntidy tEntidy = TurmaEntidy.builder()
    .turma(nameTurma).build();

  turmaRepository.save(tEntidy);
  scanner.close();

 }

 public TurmaEntidy buscarPorId(String id) {
  return turmaRepository.findById(id).orElse(null);
 }

 public List<TurmaEntidy> listarTodos() {
  return turmaRepository.findAll();
 }

 public TurmaEntidy atualizar(String id, TurmaEntidy dadosAtulizadados) {
  TurmaEntidy turma = turmaRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("turma nao encontrado"));

  turma.setTurma(dadosAtulizadados.getTurma());
  turma.setId(dadosAtulizadados.getId());

  return turmaRepository.save(turma);
 }

 public void deletar(String id) {
  turmaRepository.deleteById(id);
 }

}
