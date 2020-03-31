package com.Catalog;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public  class DataBaseHelper extends SQLiteOpenHelper
{


        private static final String DATABASE_NAME = "EmployeeDatabase";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME = "employees";
        private static final String  EmployeeID = "";
        private static final String FIRST_NAME = "";
        private static final String LAST_NAME = "";
        private static final String BIRTH_YEAR = "";
        private static final String MONTHLY_SALARY = "";
        private static final String OCCUPATION_RATE  = "";
        private static final String EMPLOYEE_TYPE = "";
        private static final String PROJECTS = "";
        private static final String CLIENTS = "";
        private static final String BUGS= "";



        public DataBaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


    @Override public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                EmployeeID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT, " +
                FIRST_NAME + " varchar(200) NOT NULL, " +
                LAST_NAME + " varchar(200) NOT NULL, " +
                BIRTH_YEAR + " varchar(200) NOT NULL, " +
                MONTHLY_SALARY + " double NOT NULL),"+
                OCCUPATION_RATE  + " varchar(200) NOT NULL),"+
                EMPLOYEE_TYPE   + " varchar(200) NOT NULL),"+
                PROJECTS  + " varchar(200) NOT NULL),"+
                CLIENTS   + " varchar(200) NOT NULL),"+
                 BUGS +" varchar(200) NOT NULL),";
                db.execSQL(sql);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


    }







}
