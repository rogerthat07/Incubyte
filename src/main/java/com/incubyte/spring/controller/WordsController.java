package com.incubyte.spring.controller;

import java.util.List;

import javax.validation.Valid;

import com.incubyte.spring.entity.Words;
import com.incubyte.spring.exception.WordDoesNotExist;
import com.incubyte.spring.service.WordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/words")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @GetMapping("/all")
    public List<Words> getAllWords(){
        return wordsService.getAllWords();
    }

    @PostMapping("/save")
    public Words saveWord(@Valid Words word){
        return wordsService.saveWord(word);
    }

    @GetMapping("/find/{id}")
    public Words findWordById(Long id) throws WordDoesNotExist{
        return wordsService.findWordsById(id);
    }

    @GetMapping("/delete/{id}")
    public Boolean deleteWordsById(Long id){
        return wordsService.deleteWordsById(id);
    }

}
