package com.mycompany.maximus.controller;

import com.mycompany.maximus.models.Ask;
import com.mycompany.maximus.repositories.AskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/maximus")
public class AskController  {
    private  final AskRepository askRepository;

    @Autowired
    public AskController(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    @PostMapping()
    public String createAsk(@ModelAttribute("ask") @Valid Ask ask, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "redirect:/maximus";
        askRepository.save(ask);
        return "redirect:/maximus";
    }
}
