package com.meli.mutantes.controller;

import com.meli.mutantes.document.Human;
import com.meli.mutantes.dto.DnaDTO;
import com.meli.mutantes.dto.StatsDTO;
import com.meli.mutantes.service.MutantesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class MutantesController {

    long conthumano = 0;
    long contmutante = 0;
    public StatsDTO stats = new StatsDTO(conthumano, contmutante);

    @PostMapping(value = "/mutant/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isMutant(@RequestBody DnaDTO dna) {
        try {
            if(MutantesService.isMutant(dna.getDna()) && MutantesService.isValid(dna.getDna())) {
                stats.SetStatsMutante();
                //System.out.println("dna = " + dna.toString());
                //System.out.println(HttpStatus.OK);
                ////////////////// POST DB ///////////////
                Human newHuman = new Human();
                newHuman.setEsMutante(true);
                newHuman.setDna(dna.getDna());
                ////////////////// POST DB ///////////////
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                //System.out.println("dna = " + dna.toString());
                //System.out.println(HttpStatus.FORBIDDEN);
                stats.SetStatsHumano();
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.toString());
        }
    }

    @GetMapping(value = "stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStats() {
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }


}

