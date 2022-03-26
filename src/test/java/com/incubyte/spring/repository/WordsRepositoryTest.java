package com.incubyte.spring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.incubyte.spring.entity.Words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class WordsRepositoryTest {

    @Autowired
    private WordsRepository wordsRepository;

    private TestEntityManager entityManager;

    @BeforeEach
    void setUp(){
        Words words = Words.builder().id(1L).word("test").build();
        entityManager.persist(words);
    }

    @Test
    void testFindWordsById() {
        Words words = wordsRepository.findWordsById(1L);
        assertEquals(words.getWord(), "test");
    }

    void testFindWordsByIdFailCase(){
        Words words = wordsRepository.findWordsById(1L);
        assertEquals(words.getWord(), "TEST");
    }
}
