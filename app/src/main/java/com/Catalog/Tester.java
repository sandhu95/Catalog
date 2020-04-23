package com.Catalog;

import java.io.Serializable;

public class Tester extends Employee implements Serializable {
    private  int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }
    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }

    public Tester(int eId, String fname, String lname, int age, double Salary, int rate, String eType, int nbBugs) {
        super(eId, fname, lname, age, Salary, rate, eType);
        this.nbBugs = nbBugs;
    }
}
