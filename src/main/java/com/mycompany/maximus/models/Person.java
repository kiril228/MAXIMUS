package com.mycompany.maximus.models;

import javax.persistence.*;
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Person() {
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String email, String password, int yearOfBirth) {
        this.email = email;
        this.password = password;
        this.yearOfBirth = yearOfBirth;
    }
}
