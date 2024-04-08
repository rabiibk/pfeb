package com.example.angular.springbootcrudapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String name;
    private int matricule;

    // Constructeur par défaut
    public LoginRequest() {}



}

