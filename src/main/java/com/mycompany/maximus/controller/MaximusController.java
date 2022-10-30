package com.mycompany.maximus.controller;

import com.mycompany.maximus.models.Ask;
import com.mycompany.maximus.models.GymMembership;
import com.mycompany.maximus.models.GymMembershipType;
import com.mycompany.maximus.repositories.AskRepository;
import com.mycompany.maximus.repositories.GymMembershipRepository;
import com.mycompany.maximus.services.GymMembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/maximus")
public class MaximusController {


    private  final AskRepository askRepository;
    private  final GymMembershipRepository gymMembershipRepository;

    private  final GymMembershipTypeService gymMembershipTypeService;

    @Autowired
    public MaximusController(AskRepository askRepository, GymMembershipRepository gymMembershipRepository, GymMembershipTypeService gymMembershipTypeService) {
        this.askRepository = askRepository;
        this.gymMembershipRepository = gymMembershipRepository;
        this.gymMembershipTypeService = gymMembershipTypeService;
    }



    @GetMapping()
    public String showMainPage(@ModelAttribute("ask") Ask ask) {
        return "index";
    }

    @GetMapping("/buy-season-ticket")
    public String formBuyTicket(@ModelAttribute("formBuyTicket")GymMembership gymMembership, Model model){
        model.addAttribute("listTypeTraining", gymMembershipTypeService.getTypeTraining());
        return "ordering-1";


    }

    @PostMapping("/buy-season-ticket")
    public String createGymMembership(@ModelAttribute("formBuyTicket")@Valid GymMembership gymMembership,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ordering-1";
        }
        gymMembershipRepository.save(gymMembership);
        return "redirect:/maximus/buy-season-ticket/successful";
    }


    @GetMapping("/buy-season-ticket/successful")
    public String createGymMembershipSuccessful(){
        return "ordering-2";
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
