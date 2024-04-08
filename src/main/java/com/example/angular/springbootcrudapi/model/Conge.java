package com.example.angular.springbootcrudapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
public class Conge {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private int NbrJours;
    private int matriculeC;
    private String nameC;

    @Enumerated(EnumType.STRING)
    private Etatconge etat;

    @ManyToOne
    // @JoinColumn(name = "employee_id")
    @JoinColumn(name = "matricule", referencedColumnName = "matricule")
    private Employee employee;

}
