package com.Catalog;

public class Programmer extends Employee {
    private int nbProjects;

    public int getNbProjects() {
        return nbProjects;
    }
    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }

    public Programmer(int eId,String fname, String lname, int age, double Salary, int rate, String eType, int nbProjects) {
        super(eId, fname, lname, age, Salary, rate, eType);
        this.nbProjects = nbProjects;
    }
}

