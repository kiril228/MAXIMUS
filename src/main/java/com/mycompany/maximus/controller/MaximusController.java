package com.mycompany.maximus.controller;

import com.mycompany.maximus.models.Ask;
import com.mycompany.maximus.models.GymMembership;
import com.mycompany.maximus.repositories.AskRepository;
import com.mycompany.maximus.repositories.GymMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/maximus")
public class MaximusController {


    private  final AskRepository askRepository;
    private  final GymMembershipRepository gymMembershipRepository;

    @Autowired
    public MaximusController(AskRepository askRepository, GymMembershipRepository gymMembershipRepository) {
        this.askRepository = askRepository;
        this.gymMembershipRepository = gymMembershipRepository;
    }

    @GetMapping()
    public String showMainPage(@ModelAttribute("ask") Ask ask) {
        return "index";
    }

    @GetMapping("/buy-season-ticket")
    public String formBuyTicket(@ModelAttribute("formBuyTicket")GymMembership gymMembership){
        return "ordering";

    }

    @PostMapping("/buy-season-ticket")
    public String createGymMembership(@ModelAttribute("formBuyTicket")@Valid GymMembership gymMembership,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ordering";
        }
        gymMembershipRepository.save(gymMembership);
        return "redirect:/maximus";
    }

    @PostMapping()
    public String createAsk(@ModelAttribute("ask") @Valid Ask ask, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "index";
        askRepository.save(ask);
        return "redirect:/maximus";
    }

    @GetMapping("/profile")
    public String getProfileUser(){
        return "profile";
    }



}
