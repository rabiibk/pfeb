package com.example.angular.springbootcrudapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
public class CongeMaladie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateDebut;

    private Date dateFin;

    private String motif;

    private int nbrjours;

    private int matriculeM;

    private String nameM;

    @ManyToOne
    // @JoinColumn(name = "employee_id")
    @JoinColumn(name = "matricule", referencedColumnName = "matricule")
    private Employee employee;
}
