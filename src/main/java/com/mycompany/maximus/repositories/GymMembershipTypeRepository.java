package com.mycompany.maximus.repositories;

import com.mycompany.maximus.models.GymMembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymMembershipTypeRepository extends JpaRepository<GymMembershipType, Integer> {
    Optional<GymMembershipType> findById(long idTraining);
}
