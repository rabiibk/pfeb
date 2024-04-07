package com.example.angular.springbootcrudapi.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Absence {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dateDebut;

    private Date dateFin;

    private String motif;


    @Getter
    private String nameE;

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public int getMatriculeE() {
        return matriculeE;
    }

    public void setMatriculeE(int matriculeE) {
        this.matriculeE = matriculeE;
    }

    private int matriculeE;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Employee getEmployee() {
        return employee;
    }




    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    // @JoinColumn(name = "employee_id")
    @JoinColumn(name = "matricule", referencedColumnName = "matricule")
    private Employee employee;

}
