package com.Catalog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.Nullable;


public class DataBaseHelper extends SQLiteOpenHelper
{

    RegisterEmployee rEmployee;

        private static final String DATABASE_NAME = "EmployeeDatabase";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME1 = "Employee";
        private static final String  EmployeeID = "employee_id";
        private static final String FIRST_NAME = "first_name";
        private static final String LAST_NAME = "last_name";
        private static final String AGE = "age";
        private static final String MONTHLY_SALARY = "month_salary";
        private static final String OCCUPATION_RATE  = "occupation_rate";
        private static final String EMPLOYEE_TYPE = "employee_type";
        private static final String TABLE_NAME2 = "Vehicle";
        private static final String Vehicle_Type ="vehicle_type";
        private static final String model = "model";
        private static final String plate = "plate";
        private static final String color = "color";
        private static final String TABLE_NAME3 = "Car";
        private static final String type = "car_type";
        private static final String TABLE_NAME4 = "Motorcycle";
        private static final String sideCar = "sidecar";
        private static final String TABLE_NAME5 = "Programmer";
        private static final String nbProjects = "projects";
        private static final String TABLE_NAME6 = "Manager";
        private static final String nbClients = "clients";
        private static final String TABLE_NAME7 = "Tester";
        private static final String nbBugs= "bugs";
        private static final String TABLE_NAME8 = "allemployees";



        public DataBaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }



    public void createTables(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE " + TABLE_NAME8
                + "(" + EmployeeID + " INTEGER PRIMARY KEY, "
                + FIRST_NAME + " TEXT NOT NULL, "
                + LAST_NAME + " TEXT NOT NULL);";
            db.execSQL(sql);
        }
         catch (Exception e){
            e.printStackTrace();
         }
    }
    public void createEmployee(SQLiteDatabase db ){
            try{
                String sql1 = "CREATE TABLE " + TABLE_NAME1 + "(" +
                        EmployeeID + " INTEGER PRIMARY KEY, " +
                        FIRST_NAME + " TEXT NOT NULL, " +
                        LAST_NAME + " TEXT NOT NULL, " +
                        AGE + " INTEGER NOT NULL, " +
                        MONTHLY_SALARY + " REAL NOT NULL, " +
                        OCCUPATION_RATE + " INTEGER NOT NULL, " +
                        EMPLOYEE_TYPE + " TEXT NOT NULL);";
                db.execSQL(sql1);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }
    public void createVehicle(SQLiteDatabase db ) {
        try {
            String sql2 = "CREATE TABLE " + TABLE_NAME2 + " (" +
                    EmployeeID + " INTEGER PRIMARY KEY, " +
                    Vehicle_Type + " TEXT NOT NULL, " +
                    model + " INTEGER NOT NULL, " +
                    plate + " TEXT NOT NULL, " +
                    color + " TEXT NOT NULL);";
            db.execSQL(sql2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createCar(SQLiteDatabase db ) {
        try {
            String sql3 = "CREATE TABLE " + TABLE_NAME3 + " (" +
                    EmployeeID + " INTEGER PRIMARY KEY, " +
                    type + " TEXT NOT NULL);";
            db.execSQL(sql3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createMotorcycle(SQLiteDatabase db ) {
        try {
            String sql4 = "CREATE TABLE " + TABLE_NAME4 + " (" +
                    EmployeeID + " INTEGER  PRIMARY KEY, " +
                    sideCar + " TEXT NOT NULL);";
            db.execSQL(sql4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createProgrammer(SQLiteDatabase db ) {
        try {
            String sql5 = "CREATE TABLE " + TABLE_NAME5 + " (" +
                    EmployeeID + " INTEGER PRIMARY KEY, " +
                    nbProjects + " INTEGER NOT NULL);";
            db.execSQL(sql5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createTester(SQLiteDatabase db ) {
        try {
            String sql7 = "CREATE TABLE " + TABLE_NAME7 + " (" +
                    EmployeeID + " INTEGER PRIMARY KEY, " +
                    nbBugs + " INTEGER NOT NULL);";
            db.execSQL(sql7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createManager(SQLiteDatabase db ) {
        try {
            String sq6 = "CREATE TABLE " + TABLE_NAME6 + " (" +
                    EmployeeID + " INTEGER  PRIMARY KEY, " +
                    nbClients + " INTEGER NOT NULL);";
            db.execSQL(sq6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


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
    boolean allEmployees(int eid,String fname, String lname){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createTables(getWritableDatabase());

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eid));
        cv.put(FIRST_NAME, fname);
        cv.put(LAST_NAME, lname);

        return sqLiteDatabase.insert(TABLE_NAME8, null, cv) != -1;
    }
    boolean addEmployee( int eid, String fname, String lname, int age, double asalary, int oRate, String etype) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createEmployee(getWritableDatabase());

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value
        cv.put(FIRST_NAME, fname);
        cv.put(LAST_NAME, lname);
        cv.put(AGE, String.valueOf(age));
        cv.put(MONTHLY_SALARY,String.valueOf(asalary));
        cv.put(OCCUPATION_RATE, oRate);
        cv.put(EmployeeID, String.valueOf(eid));
        cv.put(EMPLOYEE_TYPE, etype);

        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.insert(TABLE_NAME1, null, cv) != -1;
    }
    boolean addVehicle(int eid,String vType, int vModel,String vPlate, String vColor){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createVehicle(getWritableDatabase());

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

        createCar(getWritableDatabase());

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(type, cType);

        return sqLiteDatabase.insert(TABLE_NAME3, null, cv) != -1;
    }

    boolean addMotorcycle(int eId, String sCar){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createMotorcycle(getWritableDatabase());

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(sideCar, sCar);

        return sqLiteDatabase.insert(TABLE_NAME4, null, cv) != -1;
    }
    boolean addProgrammer(int eId, int projects){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createProgrammer(getWritableDatabase());

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(nbClients, projects);

        return sqLiteDatabase.insert(TABLE_NAME5, null, cv) != -1;
    }
    boolean addManager(int eId, int clients){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createManager(getWritableDatabase());

        ContentValues cv = new ContentValues();

        cv.put(EmployeeID, String.valueOf(eId));
        cv.put(nbClients, clients);

        return sqLiteDatabase.insert(TABLE_NAME6, null, cv) != -1;
    }
    boolean addTester(int eId, int bugs){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        createTester(getWritableDatabase());

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
        return sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME3, null);
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
