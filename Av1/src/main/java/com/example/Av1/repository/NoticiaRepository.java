package com.example.Av1.repository;

import com.example.Av1.model.NoticiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends MongoRepository<NoticiaEntity, String> {

}
