package com.Catalog;

public class Manager extends Employee {
    private int nbclients;

    public int getNbclients() {
        return nbclients;
    }
    public void setNbclients(int nbclients) {
        this.nbclients = nbclients;
    }

    public Manager(String fname, String lname, int age, int birthYear, double monthlySalary, int rate, int nbclients) {
        super(fname, lname, age, birthYear, monthlySalary, rate);
        this.nbclients = nbclients;
    }
}


