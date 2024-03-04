package com.example.springbootcrudapi.model;

import javax.persistence.*;
import java.util.Date;

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

    public int getMatriculeC() {
        return matriculeC;
    }

    public void setMatriculeC(int matriculeC) {
        this.matriculeC = matriculeC;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrJours() {
        return NbrJours;
    }

    public void setNbrJours(int nbrJours) {
        NbrJours = nbrJours;
    }

    public Etatconge getEtat() {
        return etat;
    }

    public void setEtat(Etatconge etat) {
        this.etat = etat;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Enumerated(EnumType.STRING)
    private Etatconge etat;

    @ManyToOne
    // @JoinColumn(name = "employee_id")
    @JoinColumn(name = "matricule", referencedColumnName = "matricule")
    private Employee employee;

}
