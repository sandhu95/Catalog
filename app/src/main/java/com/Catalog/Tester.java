package com.Catalog;

public class Tester extends Employee {
    private  int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }
    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }
    public Tester(int nbBugs) {
        this.nbBugs = nbBugs;
    }
}
