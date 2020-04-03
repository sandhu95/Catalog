package com.Catalog;

public class Tester extends Employee {
    private  int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }
    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }

    public Tester(String fname, String lname, int birthYear, double monthlySalary, int rate, int eId, String eType, int nbBugs) {
        super(fname, lname, birthYear, monthlySalary, rate, eId, eType);
        this.nbBugs = nbBugs;
    }
}
