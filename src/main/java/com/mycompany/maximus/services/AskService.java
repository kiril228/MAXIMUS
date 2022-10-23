package com.mycompany.maximus.services;

import com.mycompany.maximus.models.Ask;
import com.mycompany.maximus.repositories.AskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AskService {

    private  final AskRepository askRepository;

    @Autowired
    public AskService(AskRepository askRepository) {
        this.askRepository = askRepository;
    }

    @Transactional
    public void save(Ask newAsk){
        askRepository.save(newAsk);
    }


}
