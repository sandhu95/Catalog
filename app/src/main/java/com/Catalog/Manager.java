package com.Catalog;

public class Manager extends Employee {
    private int nbclients;

    public int getNbclients() {
        return nbclients;
    }
    public void setNbclients(int nbclients) {
        this.nbclients = nbclients;
    }

    public Manager(String fname, String lname, int birthYear, double monthlySalary, int rate, int eId, String eType, int nbclients) {
        super(fname, lname, birthYear, monthlySalary, rate, eId, eType);
        this.nbclients = nbclients;
    }
}


