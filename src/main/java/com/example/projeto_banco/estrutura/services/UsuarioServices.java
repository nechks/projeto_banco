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
@Autowired
 private UsuarioRepository usuarioRepository;

 @Cacheable(value = "usuario", key = "#id")
 public Optional<UsuarioEntidy> buscarCursoPorId(String id) {
  System.out.println("Buscando no MongoDB...");
  return usuarioRepository.findById(id);
 }

 public void adicionarCurso(){
  Scanner scanner = new Scanner(System.in);

  System.out.println("Digite o nome do usuario ");
  String nameUsuario = scanner.nextLine();
  System.out.println("RA de usuario ");
  String raUsuario = scanner.nextLine();
  System.out.println("turma ");
  String turma = scanner.nextLine();



   UsuarioEntidy uEntidy = UsuarioEntidy.builder()
  .usuario(nameUsuario)
  .usuario(raUsuario)
  .usuario(turma)
  .build();

  usuarioRepository.save(uEntidy);
  scanner.close();

  
 }

 public UsuarioEntidy buscarPorId(String id) {
  return usuarioRepository.findById(id).orElse(null);
 }

 public List <UsuarioEntidy> listarTodos(){
  return usuarioRepository.findAll();
 }

 public UsuarioEntidy atualizar(String id, UsuarioEntidy dadosAtulizadados){
  UsuarioEntidy usuario = usuarioRepository.findById(id)
   .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

   usuario.setUsuario(dadosAtulizadados.getUsuario());
   usuario.setId(dadosAtulizadados.getId());

   return usuarioRepository.save(usuario);
 }


 public void deletar(String id){
  usuarioRepository.deleteById(id);
 }


}
