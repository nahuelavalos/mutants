package com.meli.mutantes.document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "Human")
@NoArgsConstructor
@AllArgsConstructor
public class Human implements Serializable {
    @Id
    @NotNull
    private String id;

    private boolean esMutante;

    private String[] dna;

    //public Human(boolean mutante, String[] dna) {
    //}

    public boolean getEsMutante() {
        return esMutante;
    }

    public void setEsMutante(boolean esMutante) {
        this.esMutante = esMutante;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
