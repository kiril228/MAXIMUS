package com.mycompany.maximus.repositories;

import com.mycompany.maximus.models.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository<Ask, Integer> {

}
