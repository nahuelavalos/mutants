package com.meli.mutantes.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantServiceTests {

    @Test
    public void ejemploChallenge() {
        String[] ejemploChallenge = {
                "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"
        };
        assertTrue(MutantService.isMutant(ejemploChallenge));
    }

    @Test
    public void ejemploHumano() {
        String[] ejemploHumano = {
                "ATGCGA","CGGTCC","TTATGT","AGAAGG","CTCCTA","TCACTG"
        };
        assertFalse(MutantService.isMutant(ejemploHumano));
    }

    @Test
    public void ejemploFull() {
         String[] ejemploFull= {
            "ATGCGA", "CAGCGC", "TTCGGT", "ACAAGG", "CCCCTG", "TCACTG"};
         assertTrue(MutantService.isMutant(ejemploFull));
    }

    @Test
    public void testHorizontalDNA() {
        String[] horizontalDNA = {
                "CCCCC", "ATCGT", "ATCGT", "CTTTT", "CAGAC"
        };
        assertTrue(MutantService.isMutant(horizontalDNA));
    }

    @Test
    public void testVerticualDNA() {
        String[] verticalDNA = {
                "CGCGC", "ATCGT", "ATCGT", "CTCTT", "CAGAT"
        };
        assertTrue(MutantService.isMutant(verticalDNA));
    }

    @Test
    public void testDiagonalDNA() {
        String[] diagonalDNA = {
                "CCACC", "ACCGT", "AACGT", "CTACA", "CAGAT"
        };
        assertTrue(MutantService.isMutant(diagonalDNA));
    }

    @Test
    public void testAntiDiagonalDNA() {
        String[] antiDiagonalDNA = {
                "CGCCC", "ATCGT", "ACGGT", "CGCTT", "GAGAG"
        };
        assertTrue(MutantService.isMutant(antiDiagonalDNA));
    }

    @Test
    public void testNull() {
        String[] testNull = null;
        assertFalse(MutantService.isValid(testNull));
    }

    @Test
    public void testVacio() {
        String[] testVacio = {""};
        assertFalse(MutantService.isValid(testVacio));
    }

    @Test
    public void testMatrizChica() {
        String[] testMatrizChica = {"CGA", "TGC", "TTA"};
        assertFalse(MutantService.isValid(testMatrizChica));
    }

    @Test
    public void testNXM() {
        String[] testNXM = {"ATGCGA","CGGTCC","TTATGT","AGAAGG"};
        assertFalse(MutantService.isValid(testNXM));
    }

    @Test
    public void testLetraInvalidad() {
        String[] testLetraInvalidad = {"ATGCGA","CGGTCC","TTATGT","AGAAXG","CTCCTA","TCACTG"};
        assertFalse(MutantService.isValid(testLetraInvalidad));
    }

}