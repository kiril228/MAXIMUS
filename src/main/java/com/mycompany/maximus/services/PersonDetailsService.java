package com.mycompany.maximus.services;

import com.mycompany.maximus.models.Person;
import com.mycompany.maximus.repositories.PersonRepository;
import com.mycompany.maximus.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> optionalPerson = personRepository.findByEmail(email);
        if(optionalPerson.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new PersonDetails(optionalPerson.get());
    }


}
