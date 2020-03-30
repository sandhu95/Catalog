package com.Catalog;

public class Manager extends Employee {
    private int nbclients;

    public int getNbclients() {
        return nbclients;
    }
    public void setNbclients(int nbclients) {
        this.nbclients = nbclients;
    }
    public Manager(int nbclients,String name,int age,int birthYear,double monthlySalary,int rate) {
        super(name,age,birthYear,monthlySalary,rate);
        this.nbclients = nbclients;
    }
}
