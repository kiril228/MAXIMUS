package com.mycompany.maximus.models;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Optional;

@Entity
@Table(name = "gym_membership")
@Valid
public class GymMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column( name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "commentary")
    private String commentary;



    @ManyToOne
    @JoinColumn(name = "id_gym_membership_type",
    referencedColumnName = "id")
        private GymMembershipType gymMembershipType;

    public GymMembership() {
    }

    public GymMembership(String name, String surname, String phoneNumber, String email, String commentary, String gymMembershipType) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.commentary = commentary;

    }

    public GymMembership(String name, String surname, String phoneNumber, String email, String commentary, GymMembershipType gymMembershipType) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.commentary = commentary;
        this.gymMembershipType = gymMembershipType;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public GymMembershipType getGymMembershipType() {
        return gymMembershipType;
    }

    public void setGymMembershipType(GymMembershipType gymMembershipType) {
        this.gymMembershipType = gymMembershipType;
    }
}


