package com.example.projeto_banco.estrutura.entidade;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "turmaEntidy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TurmaEntidy {

    @Id
    private String id;
    private String turma;
}
