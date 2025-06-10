package com.example.projeto_banco.estrutura.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoEntidy {
    @Id
    private String id;
    private String curso;

}
