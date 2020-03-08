package com.meli.mutantes.repository;

import com.meli.mutantes.document.Human;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface HumanRepository extends MongoRepository<Human, Serializable> {



}
