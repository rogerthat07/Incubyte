package com.incubyte.spring.repository;

import com.incubyte.spring.entity.Words;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<Words, Long> {

    Words findWordsById(Long id);
    
}
