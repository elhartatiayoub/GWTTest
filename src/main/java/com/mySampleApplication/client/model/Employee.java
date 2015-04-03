package com.mySampleApplication.client.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Iob on 02/04/2015.
 */
public class Employee {
    private String cin;
    private String nom;
    private String prenom;
    private long salire;
    private Date dateNaiss;

    public Employee() {
    }

    public Employee(String cin, String nom, String prenom, long salire, Date dateNaiss) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.salire = salire;
        this.dateNaiss = dateNaiss;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getSalire() {
        return salire;
    }

    public void setSalire(long salire) {
        this.salire = salire;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Employee(int i){
        cin = "aa"+ ((int) (Math.random() * 1000));
        nom = "nom "+i;
        prenom = "prenom "+i;
        salire = 10000*i;
        dateNaiss = new Date(new Date().getTime()-10000000*i);
    }
}
