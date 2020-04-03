package com.Catalog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
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
        private static final String Vehicle_Type ="";
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
        private static final String TABLE_NAME8 = "AllEmployees";



        public DataBaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


    @Override public void onCreate(SQLiteDatabase db) {
    try {
        String sql = "CREATE TABLE " + TABLE_NAME1 + "(" +
                EmployeeID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY, " +
                FIRST_NAME + " TEXT NOT NULL, " +
                LAST_NAME + " TEXT NOT NULL, " +
                BIRTH_YEAR + " INTEGER NOT NULL, " +
                MONTHLY_SALARY + " REAL NOT NULL," +
                OCCUPATION_RATE + " INTEGER NOT NULL," +
                EMPLOYEE_TYPE + " TEXT NOT NULL);";
        db.execSQL(sql);
        String sql2 = "CREATE TABLE " + TABLE_NAME2 + "(" +
                EmployeeID +"INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY,"+
                Vehicle_Type +"varchar NOT NULL,"+
                model + " INTEGER NOT NULL, " +
                plate + " TEXT NOT NULL, " +
                color + " TEXT NOT NULL);";
        db.execSQL(sql2);
        String sq3 = "CREATE TABLE " + TABLE_NAME3 + "(" +
                EmployeeID +"INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY,"+
                type + " TEXT NOT NULL);";
        db.execSQL(sq3);
        String sq4 = "CREATE TABLE " + TABLE_NAME4 + "(" +
                EmployeeID +"INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY,"+
                sideCar + " TEXT NOT NULL);";
        db.execSQL(sq4);
        String sq5 = "CREATE TABLE " + TABLE_NAME5 + "(" +
                EmployeeID +"INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY,"+
                nbProjects + " INTEGER NOT NULL);";
        db.execSQL(sq5);
        String sq6 = "CREATE TABLE " + TABLE_NAME6 + "(" +
                EmployeeID +"INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY,"+
                nbClients + " INTEGER NOT NULL);";
        db.execSQL(sq6);
        String sq7 = "CREATE TABLE " + TABLE_NAME7 + "(" +
                EmployeeID +"INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY,"+
                nbBugs + " INTEGER NOT NULL);";
        db.execSQL(sq7);
        String sql8 = "CREATE TABLE " + TABLE_NAME8 + "(" +
                EmployeeID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY, " +
                FIRST_NAME + " TEXT NOT NULL, " +
                LAST_NAME + " TEXT NOT NULL);";
        db.execSQL(sql8);
    }
    catch( Exception e){
            Log.e("dbAdapter", e.getMessage());
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sql1 = "DROP TABLE IF EXISTS " + TABLE_NAME1 + ";";
        db.execSQL(sql1);
        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME2 + ";";
        db.execSQL(sql2);
        String sql3 = "DROP TABLE IF EXISTS " + TABLE_NAME3 + ";";
        db.execSQL(sql3);
        String sql4 = "DROP TABLE IF EXISTS " + TABLE_NAME4 + ";";
        db.execSQL(sql4);
        String sql5 = "DROP TABLE IF EXISTS " + TABLE_NAME5 + ";";
        db.execSQL(sql5);
        String sql6 = "DROP TABLE IF EXISTS " + TABLE_NAME6 + ";";
        db.execSQL(sql6);
        String sql7 = "DROP TABLE IF EXISTS " + TABLE_NAME7 + ";";
        db.execSQL(sql7);
        onCreate(db);

    }
    boolean addEmployee(String fname, String lname, int byear, double asalary, int oRate, int eid, String etype) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value
        cv.put(FIRST_NAME, fname);
        cv.put(LAST_NAME, lname);
        cv.put(BIRTH_YEAR, String.valueOf(byear));
        cv.put(MONTHLY_SALARY,asalary);
        cv.put(OCCUPATION_RATE, oRate);
        cv.put(EmployeeID, eid);
        cv.put(EMPLOYEE_TYPE, etype);

        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.insert(TABLE_NAME1, null, cv) != -1;
    }
    boolean allEmployees(String fname, String lname,int eid){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(FIRST_NAME, fname);
        cv.put(LAST_NAME, lname);
        cv.put(EmployeeID, eid);

        return sqLiteDatabase.insert(TABLE_NAME8, null, cv) != -1;
    }
    boolean addVehicle(int eid,String vType, int vModel,String vPlate, String vColor){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(Vehicle_Type, vType);
        cv.put(plate, vPlate);
        cv.put(model, String.valueOf(vModel));
        cv.put(EmployeeID, String.valueOf(eid));
        cv.put(color, vColor);
        return sqLiteDatabase.insert(TABLE_NAME2, null, cv) != -1;
    }

    boolean addCar(int eId, String cType){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(type, cType);

        return sqLiteDatabase.insert(TABLE_NAME3, null, cv) != -1;
    }
    boolean addMotorcycle(int eId, String sCar){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(sideCar, sCar);

        return sqLiteDatabase.insert(TABLE_NAME4, null, cv) != -1;
    }
    boolean programmer(int eId, int projects){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(nbClients, projects);

        return sqLiteDatabase.insert(TABLE_NAME5, null, cv) != -1;
    }
    boolean manager(int eId, int clients){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(nbClients, clients);

        return sqLiteDatabase.insert(TABLE_NAME6, null, cv) != -1;
    }
    boolean tester(int eId, int bugs){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(nbBugs, bugs);

        return sqLiteDatabase.insert(TABLE_NAME7, null, cv) != -1;
    }
    Cursor getEmployees() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
    }
    Cursor getVehicle() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
    }
    Cursor getCar() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME3, null);
    }
    Cursor getMotorcycle() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME4, null);
    }
    Cursor getProgrammer() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME5, null);
    }
    Cursor getManager() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME6, null);
    }
    Cursor getTester() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME7, null);
    }
    Cursor getAllEmployees() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME8, null);
    }

}
