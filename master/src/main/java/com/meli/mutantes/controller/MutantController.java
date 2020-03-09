package com.meli.mutantes.controller;

import com.meli.mutantes.document.Human;
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
import java.util.Optional;

@RestController
    public class MutantController {

    @PostMapping(value = "/mutant/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> isMutant(@RequestBody DnaDTO dna) {
        try {
            if(MutantService.isMutant(dna.getDna()) && MutantService.isValid(dna.getDna())) {
                saveDna(true, dna);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                saveDna(false, dna);
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

    //MANDAR AL SERVICE////////////////////////////////////////////////////

    @Autowired
    HumanRepository humanRepository;

    @Autowired
    MutantService mutantService;

    public void saveDna(boolean isMutant, DnaDTO dna) {
        Human newHuman = new Human();
        newHuman.setMutante(isMutant);
        newHuman.setDna(dna.getDna());
        Optional<Human> isPresent = humanRepository.findByDna(dna.getDna());
        if (!isPresent.isPresent()) {
            humanRepository.save(newHuman);
        }
        else {
            System.out.println("ADN DUPLICADO");
        }
    }

    //MANDAR AL SERVICE////////////////////////////////////////////////////

}

