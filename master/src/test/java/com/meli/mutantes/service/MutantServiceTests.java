package com.meli.mutantes.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantServiceTests {

    @Test
    public void testChallenge() {
        String[] testChallenge = {
                "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"
        };
        assertTrue(MutantService.isMutant(testChallenge));
    }

    @Test
    public void testHumano() {
        String[] testHumano = {
                "ATGCGA","CGGTCC","TTATGT","AGAAGG","CTCCTA","TCACTG"
        };
        assertFalse(MutantService.isMutant(testHumano));
    }

    @Test
    public void testFull() {
         String[] testFull= {
            "ATGCGA", "CAGCGC", "TTCGGT", "ACAAGG", "CCCCTG", "TCACTG"};
         assertTrue(MutantService.isMutant(testFull));
    }

    @Test
    public void testHorizontal() {
        String[] testHorizontal = {
                "CCCCC", "ATCGT", "ATCGT", "CTTTT", "CAGAC"
        };
        assertTrue(MutantService.isMutant(testHorizontal));
    }

    @Test
    public void testVertical() {
        String[] testVertical = {
                "CGCGC", "ATCGT", "ATCGT", "CTCTT", "CAGAT"
        };
        assertTrue(MutantService.isMutant(testVertical));
    }

    @Test
    public void testDiagonalIzqADer() {
        String[] testDiagonalIzqADer = {
                "CCACC", "ACCGT", "AACGT", "CTACA", "CAGAT"
        };
        assertTrue(MutantService.isMutant(testDiagonalIzqADer));
    }

    @Test
    public void testAntiDiagonalDerAIzq() {
        String[] testAntiDiagonalDerAIzq = {
                "CGCCC", "ATCGT", "ACGGT", "CGCTT", "GAGAG"
        };
        assertTrue(MutantService.isMutant(testAntiDiagonalDerAIzq));
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
    public void testLetraInvalida() {
        String[] testLetraInvalida = {"ATGCGA","CGGTCC","TTATGT","AGAAXG","CTCCTA","TCACTG"};
        assertFalse(MutantService.isValid(testLetraInvalida));
    }

}