package com.mycompany.maximus.repositories;

import com.mycompany.maximus.models.GymMembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMembershipTypeRepository extends JpaRepository<GymMembershipType, Integer> {
}
