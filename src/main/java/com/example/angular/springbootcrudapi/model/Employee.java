package com.example.angular.springbootcrudapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private int phone;
    private int matricule;
    private String department;

    @OneToMany(mappedBy = "employee")
    private List<Conge> conges;

    @OneToMany(mappedBy = "employee")
    private List<CongeMaladie> congesMaladie;

    @OneToMany(mappedBy = "employee")
    private List<Absence> absences;
}
