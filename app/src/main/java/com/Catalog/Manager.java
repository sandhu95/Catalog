package com.Catalog;

public class Manager extends Employee {
    private int nbclients;

    public int getNbclients() {
        return nbclients;
    }
    public void setNbclients(int nbclients) {
        this.nbclients = nbclients;
    }

    public Manager(int eId, String fname, String lname, int age, double Salary, int rate,  String eType, int nbclients) {
        super(eId, fname, lname, age, Salary, rate, eType);
        this.nbclients = nbclients;
    }
}


