package com.example.projeto_banco.estrutura.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collation = "periodoEntidy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodoEntidy {
    @Id
    private String id;
    private String periodo;
}
