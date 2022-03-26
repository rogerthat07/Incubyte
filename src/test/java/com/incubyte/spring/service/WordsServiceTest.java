package com.incubyte.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.incubyte.spring.entity.Words;
import com.incubyte.spring.exception.WordDoesNotExist;
import com.incubyte.spring.repository.WordsRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class WordsServiceTest {

    @Autowired
    private WordsService wordsService;

    @Mock
    private WordsRepository wordsRepository;

    Words words;

    @BeforeAll
    void setUp(){
        words = Words.builder().id(1L).word("test").build();
        Mockito.when(wordsRepository.findWordsById(1L)).thenReturn(words);
        Mockito.when(wordsRepository.findAll()).thenReturn((List<Words>) words);
        Mockito.when(wordsRepository.save(words)).thenReturn(words);
    }

    @Test
    void testDeleteWordsById() {
    }

    @Test
    void testFindWordsById() throws WordDoesNotExist {
        assertEquals(wordsService.findWordsById(1L).getWord(), "test");
    }

    @Test
    void testGetAllWords() {
        assertEquals(wordsService.getAllWords().get(0).getWord(),"test");
    }

    @Test
    void testSaveWord() {
        Words words = Words.builder().id(1L).word("TEST").build();
        assertEquals(wordsService.saveWord(words).getWord(), "TEST");
    }

    @Test
    void testFindWordsByIdFail() throws WordDoesNotExist {
        assertEquals(wordsService.findWordsById(1L).getWord(), "test2");
    }

    @Test
    void testGetAllWordsFail() {
        assertEquals(wordsService.getAllWords().get(0).getWord(),"Fail");
    }

    @Test
    void testSaveWordFail() {
        Words words = Words.builder().id(1L).word("TEST").build();
        assertEquals(wordsService.saveWord(words).getWord(), "Fail");
    }
}
