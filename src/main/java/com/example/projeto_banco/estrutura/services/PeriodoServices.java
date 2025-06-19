package com.example.projeto_banco.estrutura.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.example.projeto_banco.estrutura.model.PeriodoEntidy;
import com.example.projeto_banco.estrutura.repository.PeriodoRepository;

public class PeriodoServices {

  Scanner scanner = new Scanner(System.in);
  @Autowired
  private PeriodoRepository periodoRepository;

  @Cacheable(value = "periodo", key = "#id")
  public Optional<PeriodoEntidy> buscarPeriodoPorId(String id) {
    System.out.println("Buscando no MongoDB...");
    return periodoRepository.findById(id);
  }

  public void adicionarPeriodo() {

    System.out.println("Digite do numero do periodo");
    String namePeriodo = scanner.nextLine();

    PeriodoEntidy pEntidy = PeriodoEntidy.builder()
        .periodo(namePeriodo).build();

    periodoRepository.save(pEntidy);

  }

  public PeriodoEntidy buscarPorId(String id) {
    return periodoRepository.findById(id).orElse(null);
  }

  public List<PeriodoEntidy> listarTodos() {
    return periodoRepository.findAll();
  }

  public PeriodoEntidy atualizar(String id, PeriodoEntidy dadosAtulizadados) {
    PeriodoEntidy periodo = periodoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("periodo nao encontrado"));

    periodo.setPeriodo(dadosAtulizadados.getPeriodo());
    periodo.setId(dadosAtulizadados.getPeriodo());

    return periodoRepository.save(periodo);
  }

  public void deletar(String id) {
    periodoRepository.deleteById(id);
  }
}
