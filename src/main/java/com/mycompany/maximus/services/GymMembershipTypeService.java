package com.mycompany.maximus.services;

import com.mycompany.maximus.models.GymMembershipType;
import com.mycompany.maximus.repositories.GymMembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GymMembershipTypeService {

    private final GymMembershipTypeRepository gymMembershipTypeRepository;

    @Autowired
    public GymMembershipTypeService(GymMembershipTypeRepository gymMembershipTypeRepository) {
        this.gymMembershipTypeRepository = gymMembershipTypeRepository;
    }

    public  GymMembershipType getTypeById(Long id){
       return gymMembershipTypeRepository.findById(id).orElse(null);
    }

    public List<GymMembershipType> getTypeTraining(){
        return  gymMembershipTypeRepository.findAll();
    }


}
