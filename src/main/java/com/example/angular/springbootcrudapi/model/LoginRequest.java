package com.example.angular.springbootcrudapi.model;

public class LoginRequest {
    private String name;
    private int matricule;

    // Constructeur par défaut
    public LoginRequest() {}

    // Getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
}

