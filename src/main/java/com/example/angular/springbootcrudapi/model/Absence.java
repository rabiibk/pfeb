package com.example.angular.springbootcrudapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
public class Absence {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String motif;
    private String nameE;
    private int matriculeE;

    @ManyToOne
    // @JoinColumn(name = "employee_id")
    @JoinColumn(name = "matricule", referencedColumnName = "matricule")
    private Employee employee;

}
