package com.example.angular.springbootcrudapi.model;

import javax.persistence.*;
import java.util.Date;

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

    public int getMatriculeM() {
        return matriculeM;
    }

    public void setMatriculeM(int matriculeM) {
        this.matriculeM = matriculeM;
    }

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    private String nameM;

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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getNbrjours() {
        return nbrjours;
    }

    public void setNbrjours(int nbrjours) {
        this.nbrjours = nbrjours;
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
