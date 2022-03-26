package com.incubyte.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.incubyte.spring.entity.Words;
import com.incubyte.spring.exception.WordDoesNotExist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @RequestMapping("/save")
    public ModelAndView saveWords(@ModelAttribute Words words, HttpServletRequest request, Model model){
        String message = "Saved Successfully!!";
        if(request.getMethod().equalsIgnoreCase("GET"))
            return new ModelAndView("save");
        Words savingIt = wordsController.saveWord(words);
        model.addAttribute("message", message);
        return new ModelAndView("save");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteWords(@PathVariable Long id, Model model){
        ModelMap map = new ModelMap();
        Boolean flag = wordsController.deleteWordsById(id);
        if(flag==true)
            map.addAttribute("message", "Deleted Successfully!!");
        return new ModelAndView("redirect:/", map);
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateWords(@PathVariable Long id, Model model) throws WordDoesNotExist{
        Words words = wordsController.findWordsById(id);
        model.addAttribute("words", words);
        if(words!=null)
            return new ModelAndView("update");
        return new ModelAndView("redirect:/");
    }

}
