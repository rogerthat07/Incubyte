package com.incubyte.spring.controller;

import com.incubyte.spring.service.WordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/words")
public class WordsController {
    @Autowired
    private WordsService wordsService;
}
