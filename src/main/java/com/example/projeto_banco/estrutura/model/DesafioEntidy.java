package com.example.projeto_banco.estrutura.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document(collection = "desafios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesafioEntidy {
    @Id
    private String id;

    private String curso;       // ID ou nome
    private String periodo;     // ID ou nome
    private String turma;       // ID ou nome
    private List<String> alunos; // Lista de nomes ou RAs
}
