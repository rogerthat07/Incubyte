package com.incubyte.spring.service;

import com.incubyte.spring.repository.WordsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordsService {
    
    @Autowired
    private WordsRepository wordsRepository;
}
