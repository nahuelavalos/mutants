package com.meli.mutantes.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class MutantesServiceTests {

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ejemploChallenge() {
        String[] ejemploChallenge = {
                "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"
        };
        //verify(humanRepository, never()).save(Mockito.any(Human.class));
        assertTrue(MutantesService.isMutant(ejemploChallenge));

    }

    @Test
    public void ejemploHumano() {
        String[] ejemploHumano = {
                "ATGCGA","CGGTCC","TTATGT","AGAAGG","CTCCTA","TCACTG"
        };
        //verify(humanRepository, never()).save(Mockito.any(Human.class));
        assertFalse(MutantesService.isMutant(ejemploHumano));

    }
}