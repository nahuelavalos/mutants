package com.meli.mutantes.controller;

import com.meli.mutantes.dto.DnaDTO;
import com.meli.mutantes.service.MutantesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    public class MutantesController {

    @PostMapping(value = "/mutant/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isMutant(@RequestBody DnaDTO dna) {
        try {
            if(MutantesService.isMutant(dna.getDna()) && MutantesService.isValid(dna.getDna())) {
                //System.out.println("dna = " + dna.toString());
                //System.out.println(HttpStatus.OK);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                //System.out.println("dna = " + dna.toString());
                //System.out.println(HttpStatus.FORBIDDEN);
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.toString());
        }
    }
}

