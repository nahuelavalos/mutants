package com.meli.mutantes.repository;

import com.meli.mutantes.document.Human;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface HumanRepository extends MongoRepository<Human, String> {

    Long countByMutante(boolean mutante);
    Optional<Human> findByDna(String[] dna);


    //HumanRepository save(boolean mutante, String[] dna);

}
