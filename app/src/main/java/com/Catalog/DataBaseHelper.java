package com.Catalog;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;

import androidx.annotation.Nullable;

public  class DataBaseHelper extends SQLiteOpenHelper
{


        private static final String DATABASE_NAME = "EmployeeDatabase";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME1 = "Employee";
        private static final String  EmployeeID = "";
        private static final String FIRST_NAME = "";
        private static final String LAST_NAME = "";
        private static final String BIRTH_YEAR = "";
        private static final String MONTHLY_SALARY = "";
        private static final String OCCUPATION_RATE  = "";
        private static final String EMPLOYEE_TYPE = "";
        private static final String TABLE_NAME2 = "Vehicle";
        private static final String model = "";
        private static final String plate = "";
        private static final String color = "";
        private static final String TABLE_NAME3 = "Car";
        private static final String type = "";
        private static final String TABLE_NAME4 = "Motorcycle";
        private static final String sideCar = "";
        private static final String TABLE_NAME5 = "Programmer";
        private static final String nbProjects = "";
        private static final String TABLE_NAME6 = "Manager";
        private static final String nbClients = "";
        private static final String TABLE_NAME7 = "Tester";
        private static final String nbBugs= "";



        public DataBaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


    @Override public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME1 + "(" +
                EmployeeID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT, " +
                FIRST_NAME + " string(200) NOT NULL, " +
                LAST_NAME + " string(200) NOT NULL, " +
                BIRTH_YEAR + " int(200) NOT NULL, " +
                MONTHLY_SALARY + " double NOT NULL,"+
                OCCUPATION_RATE  + " int(200) NOT NULL,"+
                EMPLOYEE_TYPE   + " string(200) NOT NULL);";
                db.execSQL(sql);
        String sq2="CREATE TABLE " + TABLE_NAME2 + "(" +
                model + " int(200) NOT NULL, " +
                plate + " String(200) NOT NULL, " +
                color + " String(200) NOT NULL);";
        db.execSQL(sq2);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


    }







}
