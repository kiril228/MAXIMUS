package com.mycompany.maximus.repositories;

import com.mycompany.maximus.models.GymMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymMembershipRepository extends JpaRepository<GymMembership, Integer> {

    GymMembership findById(Long id);
}
