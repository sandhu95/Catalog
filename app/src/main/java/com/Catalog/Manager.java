package com.Catalog;

public class Manager extends Employee {
    private int nbclients;

    public int getNbclients() {
        return nbclients;
    }

    public void setNbclients(int nbclients) {
        this.nbclients = nbclients;
    }

    public Manager(int nbclients) {
        this.nbclients = nbclients;
    }
}
