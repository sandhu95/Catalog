package com.Catalog;

public class Programmer extends Employee {
    private int nbProjects;

    public int getNbProjects() {
        return nbProjects;
    }
    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }
    public Programmer(int nbProjects,String name,int age,int birthYear,double monthlySalary,int rate) {
        super(name,age,birthYear,monthlySalary,rate);
        this.nbProjects = nbProjects;
    }
}
