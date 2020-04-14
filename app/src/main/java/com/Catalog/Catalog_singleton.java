package com.Catalog;

class Catalog_singleton {
    public DataBaseHelper getmDatabase() {
        return mDatabase;
    }

    public void setmDatabase(DataBaseHelper mDatabase) {
        this.mDatabase = mDatabase;
    }

    private DataBaseHelper mDatabase;

    private static final Catalog_singleton ourInstance = new Catalog_singleton();

    static Catalog_singleton getInstance(){

        return ourInstance;
    }

    private Catalog_singleton() {
    }
}
