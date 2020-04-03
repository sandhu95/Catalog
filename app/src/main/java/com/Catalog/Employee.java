package com.Catalog;

public class Employee {
        private String fname;
        private String lname;
        private int birthYear;
        private double monthlySalary;
        private int eId;
        private int rate;

        public String geteType() {
                return eType;
        }

        public void seteType(String eType) {
                this.eType = eType;
        }

        private  String eType;


        public int geteId() {
                return eId;
        }
        public void seteId(int eId) { this.eId = eId; }
        public String getfName() { return fname; }
        public String getlName() {
                return lname;
        }
        public void setfName(String fname) {
                this.fname = fname;
        }
        public void setlName(String lname) {
                this.lname = lname;
        }

        public int getBirthYear() {
                return birthYear;
        }
        public void setBirthYear(int birthYear) {
                this.birthYear = birthYear;
        }
        public double getMonthlySalary() {
                return monthlySalary;
        }
        public void setMonthlySalary(double monthlySalary) {
                this.monthlySalary = monthlySalary;
        }
        public int getRate() {
                return rate;
        }
        public void setRate(int rate) {
                this.rate = rate;
        }

        public Employee(String fname,String lname,int birthYear,double monthlySalary,int rate,int eId,String eType) {
                super();
                this.eId=eId;
                this.fname=fname;
                this.lname=lname;
                this.birthYear=birthYear;
                this.monthlySalary=monthlySalary;
                this.rate=rate;
                this.eType=eType;
        }
        public Employee(int eId, String fname,String lname) {
                this.fname=fname;
                this.lname=lname;
                this.eId = eId;
        }

}
