package com.Catalog;

public class Programmer extends Employee {
    private int nbProjects;

    public int getNbProjects() {
        return nbProjects;
    }
    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }

    public Programmer(String fname, String lname, int birthYear, double monthlySalary, int rate, int eId, String eType, int nbProjects) {
        super(fname, lname, birthYear, monthlySalary, rate, eId, eType);
        this.nbProjects = nbProjects;
    }
}

