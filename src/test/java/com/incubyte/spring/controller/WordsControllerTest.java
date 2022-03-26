package com.incubyte.spring.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.incubyte.spring.entity.Words;
import com.incubyte.spring.exception.WordDoesNotExist;
import com.incubyte.spring.service.WordsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@WebMvcTest(WordsController.class)
public class WordsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordsService wordsService;

    private Words words;

    @BeforeEach
    void setup() throws WordDoesNotExist{
        words = Words.builder().id(1L).word("test").build();
        Mockito.when(wordsService.findWordsById(1L)).thenReturn(words);
    }

    @Test
    void testDeleteWordsById() {
        fail("Not Yet Implemented");
    }

    @Test
	void findWordsById() throws Exception {
        Mockito.when(wordsService.findWordsById(1L)).thenReturn(words);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/words/find/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$word").value(words.getWord()));
	}

    @Test
    void testGetAllWords() {
        fail("Not yet Implemented");
    }

    @Test
    void testSaveWord() throws Exception {
        Words inputWord = Words.builder().id(1L).word("test").build();
        Mockito.when(wordsService.saveWord(inputWord)).thenReturn(words);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/words/save").contentType(MediaType.APPLICATION_JSON)
        .content("{\"word\":\"word3\"}")).andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
