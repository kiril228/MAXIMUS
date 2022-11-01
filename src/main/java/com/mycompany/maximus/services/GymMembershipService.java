package com.mycompany.maximus.services;

import com.mycompany.maximus.models.GymMembership;
import com.mycompany.maximus.models.GymMembershipType;
import com.mycompany.maximus.repositories.GymMembershipRepository;
import com.mycompany.maximus.repositories.GymMembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GymMembershipService {
     private final GymMembershipRepository gymMembershipRepository;
     private final GymMembershipTypeRepository gymMembershipTypeRepository;

     @Autowired
    public GymMembershipService(GymMembershipRepository gymMembershipRepository, GymMembershipTypeRepository gymMembershipTypeRepository) {
        this.gymMembershipRepository = gymMembershipRepository;
         this.gymMembershipTypeRepository = gymMembershipTypeRepository;
     }



    @Transactional
    public void saveGymMembership(GymMembership gymMembership){
         gymMembershipRepository.save(gymMembership);
    }


}
