package com.mycompany.maximus.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gym_membership_type")
public class GymMembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "gymMembershipType")
    private List<GymMembership> gymMembershipList;

    public GymMembershipType() {
    }

    public GymMembershipType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GymMembershipType(String name, List<GymMembership> gymMembershipList) {
        this.name = name;
        this.gymMembershipList = gymMembershipList;
    }

    public List<GymMembership> getGymMembershipList() {
        return gymMembershipList;
    }

    public void setGymMembershipList(List<GymMembership> gymMembershipList) {
        this.gymMembershipList = gymMembershipList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
