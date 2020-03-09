package com.meli.mutantes.service;

import com.meli.mutantes.document.Human;
import com.meli.mutantes.dto.DnaDTO;
import com.meli.mutantes.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class MutantService {
    public static boolean isMutant(String[] dna) {

        String[][] mat = new String[dna.length][dna.length];
        boolean value = false;

        System.out.println("#####################################################################################");
        System.out.println("Matriz");
        for(int i=0; i<dna.length; i++) {
            for(int j = 0; j< dna.length; j++) {
                mat[i][j] = dna[i].substring(j,j+1);
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();

        System.out.print("- Horizontal: ");
        for(int i=0; i<dna.length; i++) {
            for(int j = 0; j< dna.length-3; j++) {
                if (mat[i][j].equals(mat[i][j+1]) && mat[i][j+1].equals(mat[i][j+2]) && mat[i][j+2].equals(mat[i][j+3])) {
                    System.out.print(mat[i][j] + mat[i][j+1] + mat[i][j+2] + mat[i][j+3] + " ");
                    //return true;
                    value = true;
                }
            }
        }
        System.out.println();


        System.out.print("- Vertical: ");
        for(int j=0; j<dna.length; j++) {
            for(int i = 0; i< dna.length-3; i++) {
                if (mat[i][j].equals(mat[i+1][j]) && mat[i+1][j].equals(mat[i+2][j]) && mat[i+2][j].equals(mat[i+3][j])) {
                    System.out.print(mat[i][j] + mat[i+1][j] + mat[i+2][j] + mat[i+3][j] + " ");
                    //return true;
                    value = true;
                }
            }
        }
        System.out.println();

        System.out.print("- Diagonal Izquierda a Derecha TOPDOWN: ");
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna.length - 3; j++) {
                if (mat[i][j].equals(mat[i+1][j+1]) && mat[i+1][j+1].equals(mat[i+2][j+2]) && mat[i+2][j+2].equals(mat[i+3][j+3])) {
                    System.out.print(mat[i][j] + mat[i+1][j+1] + mat[i+2][j+2] + mat[i+3][j+3] + " ");
                    //return true;
                    value = true;
                }
            }
        }
        System.out.println();

        System.out.print("- Diagonal Derecha a Izquierda TOPDOWN: ");
        for (int i = dna.length-1; i>2; i--) {
           for (int j = 0; j< dna.length - 3; j++) {
                if (mat[i][j].equals(mat[i-1][j+1]) && mat[i-1][j+1].equals(mat[i-2][j+2]) && mat[i-2][j+2].equals(mat[i-3][j+3])) {
                    System.out.print(mat[i][j] + mat[i-1][j+1] + mat[i-2][j+2] + mat[i-3][j+3] + " ");
                    //return true;
                    value = true;
                }
            }
        }
        System.out.println();

        //return false;
        return value;
    }

    public static boolean isValid(String[] dna)
    {
        if(Objects.isNull(dna) || dna.length == 0) {
            System.out.println("#####################################################################################");
            System.out.println("NULL");
            return false;
        }

        if(Stream.of(dna).anyMatch(String::isEmpty)){
            System.out.println("#####################################################################################");
            System.out.println("VACIO");
            return false;
        }


        if(dna.length < 4) {
            System.out.println("#####################################################################################");
            System.out.println("PEQUENIA");
            return false;
        }

        if(Stream.of(dna).anyMatch(s -> s.length() != dna.length)) {
            System.out.println("#####################################################################################");
            System.out.println("NXM");
            return false;
        }

        if(!Stream.of(dna).allMatch(s -> s.matches("[ATCG]+"))) {
            System.out.println("#####################################################################################");
            System.out.println("LETRA_INCORRECTA");
            return false;
        }

        return true;
    }

    @Autowired
    HumanRepository humanRepository;

    public long countMutants() {
        return humanRepository.countByMutante(true);
    }

    public long countHumans() {
        return humanRepository.count();
    }

    public void saveDna(boolean isMutant, DnaDTO dna) {
        Human human = new Human();
        human.setMutante(isMutant);
        human.setDna(dna.getDna());
        Optional<Human> dnaExistente = humanRepository.findByDna(dna.getDna());
        if (!dnaExistente.isPresent()) {
            humanRepository.save(human);
        }
        else {
            System.out.println("ADN DUPLICADO");
        }
    }
}

