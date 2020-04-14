package com.Catalog;

import java.util.List;

class Catalog_singleton {
    public DataBaseHelper getmDatabase() {
        return mDatabase;
    }

    public void setmDatabase(DataBaseHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    private DataBaseHelper mDatabase;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    List<Employee> employeeList;

    private static final Catalog_singleton ourInstance = new Catalog_singleton();

    static Catalog_singleton getInstance(){

        return ourInstance;
    }

    private Catalog_singleton() {
    }
}
