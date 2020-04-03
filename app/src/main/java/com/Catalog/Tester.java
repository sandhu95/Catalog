package com.Catalog;

public class Tester extends Employee {
    private  int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }
    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }

    public Tester(String fname, String lname, int age, int birthYear, double monthlySalary, int rate, int nbBugs) {
        super(fname, lname, age, birthYear, monthlySalary, rate);
        this.nbBugs = nbBugs;
    }
}
