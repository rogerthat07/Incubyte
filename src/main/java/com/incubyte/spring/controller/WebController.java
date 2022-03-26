package com.incubyte.spring.controller;

import java.util.List;

import com.incubyte.spring.entity.Words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    
    @Autowired
    private WordsController wordsController;

    @GetMapping("/")
    public ModelAndView getHome(Model model){
        List<Words> words = wordsController.getAllWords();
        model.addAttribute("words", words);
        return new ModelAndView("home");
    }

}
