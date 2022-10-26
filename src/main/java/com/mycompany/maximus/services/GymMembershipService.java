package com.mycompany.maximus.services;

import com.mycompany.maximus.models.GymMembership;
import com.mycompany.maximus.repositories.GymMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GymMembershipService {
     private final GymMembershipRepository gymMembershipRepository;

     @Autowired
    public GymMembershipService(GymMembershipRepository gymMembershipRepository) {
        this.gymMembershipRepository = gymMembershipRepository;
    }

    @Transactional
    public void saveGymMembership(GymMembership gymMembership){
         gymMembershipRepository.save(gymMembership);
    }


}
