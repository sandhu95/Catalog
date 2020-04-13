package com.Catalog;

public class Manager extends Employee {
    private int nbclients;

    public int getNbclients() {
        return nbclients;
    }
    public void setNbclients(int nbclients) {
        this.nbclients = nbclients;
    }

    public Manager(String fname, String lname, int age, double Salary, int rate, int eId, String eType, int nbclients) {
        super(eId, fname, lname, age, Salary, rate, eType);
        this.nbclients = nbclients;
    }
}


