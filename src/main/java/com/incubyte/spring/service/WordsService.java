package com.incubyte.spring.service;

import java.util.List;

import com.incubyte.spring.entity.Words;
import com.incubyte.spring.exception.WordDoesNotExist;
import com.incubyte.spring.repository.WordsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordsService {
    
    @Autowired
    private WordsRepository wordsRepository;

    public List<Words> getAllWords() {
        return wordsRepository.findAll();
    }

    public Words saveWord(Words word) {
        return wordsRepository.save(word);
    }

    public Words findWordsById(Long id) throws WordDoesNotExist {
        Words words = wordsRepository.findWordsById(id);
        if(words==null)
            throw new WordDoesNotExist("Word does not exist");
        
        return words;
    }

    public Boolean deleteWordsById(Long id) {
        Words words = wordsRepository.findWordsById(id);
        if(words!=null){
            wordsRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
