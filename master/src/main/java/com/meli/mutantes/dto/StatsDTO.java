package com.meli.mutantes.dto;

import lombok.Data;

@Data
public class StatsDTO {

    private Long count_mutant_dna;

    private Long count_human_dna;

    private Double ratio;

    public StatsDTO(Long countHuman, Long countMutant) {
        this.count_mutant_dna = countMutant;
        this.count_human_dna = countHuman;
        this.ratio = countHuman == 0 ? 1d : (double) countMutant / (double) countHuman;
    }
}
