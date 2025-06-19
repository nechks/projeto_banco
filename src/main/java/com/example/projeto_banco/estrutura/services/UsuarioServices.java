package com.example.projeto_banco.estrutura.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.projeto_banco.estrutura.model.UsuarioEntidy;
import com.example.projeto_banco.estrutura.repository.UsuarioRepository;

@Service
public class UsuarioServices {
  Scanner scanner = new Scanner(System.in);
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Cacheable(value = "usuario", key = "#id")
  public Optional<UsuarioEntidy> buscarUsuarioPorId(String id) {
    System.out.println("Buscando no MongoDB...");
    return usuarioRepository.findById(id);
  }

  public void adicionarUsuario() {

    System.out.println("Digite o nome do usuário: ");
    String nomeUsuario = scanner.nextLine();

    System.out.println("RA do usuário: ");
    String raUsuario = scanner.nextLine();

    System.out.println("Turma do usuário: ");
    String turma = scanner.nextLine();

    UsuarioEntidy uEntidy = UsuarioEntidy.builder()
        .usuario(nomeUsuario)
        .ra(raUsuario)
        .turma(turma)
        .build();

    usuarioRepository.save(uEntidy);

    // NÃO fechar o scanner aqui para evitar problemas com System.in
  }

  public UsuarioEntidy buscarPorId(String id) {
    return usuarioRepository.findById(id).orElse(null);
  }

  public List<UsuarioEntidy> listarTodos() {
    return usuarioRepository.findAll();
  }

  public UsuarioEntidy atualizar(String id, UsuarioEntidy dadosAtualizados) {
    UsuarioEntidy usuario = usuarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    usuario.setUsuario(dadosAtualizados.getUsuario());
    usuario.setRa(dadosAtualizados.getRa());
    usuario.setTurma(dadosAtualizados.getTurma());

    return usuarioRepository.save(usuario);
  }

  public void deletar(String id) {
    usuarioRepository.deleteById(id);
  }
}
