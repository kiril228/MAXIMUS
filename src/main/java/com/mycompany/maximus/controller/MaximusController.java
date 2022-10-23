package com.mycompany.maximus.controller;

import com.mycompany.maximus.models.Ask;
import com.mycompany.maximus.repositories.AskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/maximus")
public class MaximusController {

    private  final  AskRepository askRepository;

    @Autowired
    public MaximusController(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    @GetMapping()
    public String showMainPage(@ModelAttribute("ask") Ask ask) {

        return "index";
    }


    @PostMapping()
    public String createAsk(@ModelAttribute("ask") @Valid Ask ask, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "redirect:/maximus";
        askRepository.save(ask);
        return "redirect:/maximus";
    }
}
