package com.Catalog;

public class Programmer extends Employee {
    private int nbProjects;

    public int getNbProjects() {
        return nbProjects;
    }
    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }
    public Programmer(int nbProjects) {
        this.nbProjects = nbProjects;
    }
}
