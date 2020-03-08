package com.meli.mutantes.document;

import com.meli.mutantes.repository.HumanRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "Human")
@NoArgsConstructor
@AllArgsConstructor
public class Human {
    @Id
    @NotNull
    private String id;

    private String[] dna;

    private boolean mutante;


    public boolean getMutante() {
        return mutante;
    }

    public void setMutante(boolean mutante) {
        this.mutante = mutante;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

}
