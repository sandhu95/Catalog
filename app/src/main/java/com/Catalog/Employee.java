package com.Catalog;

import java.io.Serializable;

public class Employee implements Serializable {
        private String fname;
        private String lname;
        private int age;
        private double Salary;
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

        public int getage() {
                return age;
        }
        public void setage(int age) {
                this.age = age;
        }
        public double getSalary() {
                return Salary;
        }
        public void setSalary(double monthlySalary) {
                this.Salary = Salary;
        }
        public int getRate() {
                return rate;
        }
        public void setRate(int rate) {
                this.rate = rate;
        }

        public Employee(int eId,String fname,String lname,int age,double Salary,int rate,String eType) {
                super();
                this.eId=eId;
                this.fname=fname;
                this.lname=lname;
                this.age=age;
                this.Salary=Salary;
                this.rate=rate;
                this.eType=eType;
        }
        public Employee(int eId, String fname,String lname) {
                this.fname=fname;
                this.lname=lname;
                this.eId = eId;
        }

}
