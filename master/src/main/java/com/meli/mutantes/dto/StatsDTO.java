package com.meli.mutantes.dto;

import lombok.Data;

@Data
public class StatsDTO {

    private Long count_mutant_dna;

    private Long count_human_dna;

    private Double ratio;

    public StatsDTO(Long countHuman, Long countMutant) {
        this.count_mutant_dna = countHuman;
        this.count_human_dna = countMutant;
        this.ratio = countHuman == 0 ? 1d : (double) countMutant / (double) countHuman;
    }

    public void SetStatsMutante()
    {
        this.count_human_dna++;
        this.count_mutant_dna++;
        this.ratio = this.count_human_dna == 0 ? 1d : (double) this.count_mutant_dna / (double) this.count_human_dna;
    }

    public void SetStatsHumano()
    {
        this.count_human_dna++;
        this.ratio = this.count_human_dna == 0 ? 1d : (double) this.count_mutant_dna / (double) this.count_human_dna;
    }



}
