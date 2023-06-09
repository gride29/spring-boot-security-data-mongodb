package com.gride29.spring.jwt.mongodb.repository;

import com.gride29.spring.jwt.mongodb.models.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
    Optional<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}