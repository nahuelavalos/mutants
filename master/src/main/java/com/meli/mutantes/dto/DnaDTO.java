package com.meli.mutantes.dto;

public class DnaDTO {
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineFeed = "\n";

        for(int i=0; i<dna.length; i++)
        {
            sb.append(dna[i] + " ");
        }

        return sb.toString();
    }
}



