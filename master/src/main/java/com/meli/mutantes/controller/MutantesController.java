package com.meli.mutantes.controller;

import com.meli.mutantes.dto.DnaDTO;
import com.meli.mutantes.service.MutantesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    public class MutantesController {

    @RequestMapping(value = "/prueba/", method = RequestMethod.POST)
    public String home() {
        //CMD Windows//
        //curl --header "Content-Type: application/json" -d "{\"value\":\"node JS\"}" http://localhost:8080/mutant/
        System.out.println("Recibido");
        //System.out.println(consumes);
        return "200-OK";
    }

    @PostMapping(value = "/mutant/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isMutant(@RequestBody DnaDTO dna) {
        try {
            if(MutantesService.isMutant(dna)) {
                //return ResponseEntity.status(HttpStatus.OK).body(toString());
                System.out.println("dna = " + dna.toString());
                System.out.println(HttpStatus.OK);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                System.out.println("dna = " + dna.toString());
                System.out.println(HttpStatus.FORBIDDEN);
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.toString());
        }
    }
}

