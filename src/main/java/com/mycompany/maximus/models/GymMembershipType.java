package com.mycompany.maximus.models;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.persistence.*;

@Entity
@Table(name = "gym_membership_type")
public class GymMembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public GymMembershipType() {
    }

    public GymMembershipType(Long id, String name) {
        this.id = id;
        this.name = name;
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
