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

    @Test
    public void ejemploFull() {
         String[] ejemploFull= {
            "ATGCGA", "CAGCGC", "TTCGGT", "ACAAGG", "CCCCTG", "TCACTG"};
        //verify(humanRepository, never()).save(Mockito.any(Human.class));
         assertTrue(MutantesService.isMutant(ejemploFull));

    }

    @Test
    public void testHorizontalDNA() {
        String[] horizontalDNA = {
                "CCCCC",
                "ATCGT",
                "ATCGT",
                "CTTTT",
                "CAGAC"
        };
        //verify(humanRepository, never()).save(Mockito.any(Human.class));
        assertTrue(MutantesService.isMutant(horizontalDNA));
    }

    @Test
    public void testVerticualDNA() {
        String[] verticalDNA = {
                "CGCGC",
                "ATCGT",
                "ATCGT",
                "CTCTT",
                "CAGAT"
        };
      //  verify(humanRepository, never()).save(Mockito.any(Human.class));
        assertTrue(MutantesService.isMutant(verticalDNA));
    }

    @Test
    public void testDiagonalDNA() {
        String[] diagonalDNA = {
                "CCACC",
                "ACCGT",
                "AACGT",
                "CTACA",
                "CAGAT"
        };
    //    verify(humanRepository, never()).save(Mockito.any(Human.class));
        assertTrue(MutantesService.isMutant(diagonalDNA));
    }

    @Test
    public void testAntiDiagonalDNA() {
        String[] antiDiagonalDNA = {
                "CGCCC",
                "ATCGT",
                "ACGGT",
                "CGCTT",
                "GAGAG"
        };
     //   verify(humanRepository, never()).save(Mockito.any(Human.class));
        //verify(Mockito.any(DnaDTO.class));
        assertTrue(MutantesService.isMutant(antiDiagonalDNA));

    }

    @Test
    public void testNull() {
        String[] testNull = null;
        assertFalse(MutantesService.isValid(testNull));
    }

    @Test
    public void testVacio() {
        String[] testVacio = {""};
        assertFalse(MutantesService.isValid(testVacio));
    }

    @Test
    public void testMatrizChica() {
        String[] testMatrizChica = {"CGA", "TGC", "TTA"};
        assertFalse(MutantesService.isValid(testMatrizChica));
    }

    @Test
    public void testNXM() {
        String[] testNXM = {"ATGCGA","CGGTCC","TTATGT","AGAAGG"};
        assertFalse(MutantesService.isValid(testNXM));
    }

    @Test
    public void testLetraInvalidad() {
        String[] testLetraInvalidad = {"ATGCGA","CGGTCC","TTATGT","AGAAXG","CTCCTA","TCACTG"};
        assertFalse(MutantesService.isValid(testLetraInvalidad));
    }

}