package com.example.projeto_banco.estrutura.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "usuarioEntidy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEntidy {

    @Id
    private String id;
    private String usuario;
    private String ra;
    private String turma;



}
