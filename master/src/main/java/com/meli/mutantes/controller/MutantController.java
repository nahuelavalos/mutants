package com.meli.mutantes.controller;

import com.meli.mutantes.dto.DnaDTO;
import com.meli.mutantes.dto.StatsDTO;
import com.meli.mutantes.repository.HumanRepository;
import com.meli.mutantes.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class MutantController {

    @PostMapping(value = "/mutant/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isMutant(@RequestBody DnaDTO dna) {
        try {
            if(mutantService.isMutant(dna.getDna()) && mutantService.isValid(dna.getDna())) {
                mutantService.saveDna(true, dna);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                mutantService.saveDna(false, dna);
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.toString());
        }
    }

    @GetMapping(value = "stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStats() {
        StatsDTO stats = new StatsDTO(mutantService.countHumans(), mutantService.countMutants());
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }

    @Autowired
    HumanRepository humanRepository;

    @Autowired
    MutantService mutantService;
}

