package com.meli.mutantes.service;

import org.springframework.stereotype.Service;

@Service
public class MutantesService {

    String[] dna_original = {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"};

    static String[] adn_full = {
            "ATGCGA",
            "CAGCGC",
            "TTCGGT",
            "ACAAGG",
            "CCCCTG",
            "TCACTG"};



    public static boolean isMutant(String[] dna) {

        String[][] mat = new String[dna.length][dna.length];

        boolean isValid = false;

        System.out.println("#####################################################################################");
        System.out.println("Matriz");
      for(int i=0; i<dna.length; i++)
      {
        for(int j = 0; j< dna.length; j++)
        {
            mat[i][j] = dna[i].substring(j,j+1);
            System.out.print(mat[i][j] + " ");
        }
        System.out.println();
    }
        //System.out.println("");

    //HORIZONTAL
        System.out.print("- Horizontal: ");
        for(int i=0; i<dna.length; i++) {
        for(int j = 0; j< dna.length-3; j++) {
            if (mat[i][j].equals(mat[i][j+1]) && mat[i][j+1].equals(mat[i][j+2]) && mat[i][j+2].equals(mat[i][j+3])) {
                System.out.print(mat[i][j] + mat[i][j+1] + mat[i][j+2] + mat[i][j+3] + " ");
                return true;
                //isValid = true;
            }
        }
    }
        System.out.println();

    //VERTICAL
        System.out.print("- Vertical: ");
        for(int j=0; j<dna.length; j++) {
        for(int i = 0; i< dna.length-3; i++) {
            if (mat[i][j].equals(mat[i+1][j]) && mat[i+1][j].equals(mat[i+2][j]) && mat[i+2][j].equals(mat[i+3][j])) {
                System.out.print(mat[i][j] + mat[i+1][j] + mat[i+2][j] + mat[i+3][j] + " ");
                return true;
                //isValid = true;
            }
        }
    }
        System.out.println();

    //DIAGONAL IZQUIERDA A DERECHA
        System.out.print("- Diagonal Izquierda a Derecha TOPDOWN: ");
        for (int i = 0; i < dna.length - 3; i++) {
        for (int j = 0; j < dna.length - 3; j++) {
            if (mat[i][j].equals(mat[i+1][j+1]) && mat[i+1][j+1].equals(mat[i+2][j+2]) && mat[i+2][j+2].equals(mat[i+3][j+3])) {
                System.out.print(mat[i][j] + mat[i+1][j+1] + mat[i+2][j+2] + mat[i+3][j+3] + " ");
                return true;
                //isValid = true;
            }
        }
    }
        System.out.println();

    //DIAGONAL DERECHA A IZQUIERDA
        System.out.print("- Diagonal Derecha a Izquierda TOPDOWN: ");
        for (int i = dna.length-1; i>2; i--) {
        for (int j = 0; j< dna.length - 3; j++) {
            if (mat[i][j].equals(mat[i-1][j+1]) && mat[i-1][j+1].equals(mat[i-2][j+2]) && mat[i-2][j+2].equals(mat[i-3][j+3])) {
                System.out.print(mat[i][j] + mat[i-1][j+1] + mat[i-2][j+2] + mat[i-3][j+3] + " ");
                return true;
                //isValid = true;
            }
        }
    }
        System.out.println();

        return false;
        //return isValid;
    }


}

