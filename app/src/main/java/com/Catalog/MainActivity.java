package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import  java.lang.String;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DataBaseHelper DATABASE_NAME;
    List<Employee> employeeList;
    List<Vehicle> vehicleList;
    List<Car> carList;
    List<Motorcycle> motorcycleList;
    List<Programmer> programmerList;
    List<Manager> managerList;
    List<Tester> testerList;
    List<Employee> allEmployeestesterList;
    ListView listViewEmployee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewEmployee = findViewById(R.id.listview);
        employeeList = new ArrayList<>();
        vehicleList = new ArrayList<>();
        carList = new ArrayList<>();
        motorcycleList = new ArrayList<>();
        programmerList = new ArrayList<>();
        managerList = new ArrayList<>();
        testerList = new ArrayList<>();
        allEmployeestesterList = new ArrayList<>();

        DATABASE_NAME = new DataBaseHelper(this);
        loadEmployees();

    }

    private void loadEmployees() {

        Cursor cursor1 = DATABASE_NAME.getEmployees();

        if (cursor1.moveToFirst()) {
            do {
                employeeList.add(new Employee(
                        cursor1.getString(0),
                        cursor1.getString(1),
                        cursor1.getInt(2),
                        cursor1.getDouble(3),
                        cursor1.getInt(4),
                        cursor1.getInt(5),
                        cursor1.getString(6)
                ));
            } while (cursor1.moveToNext());
            cursor1.close();
        }

        Cursor cursor2 = DATABASE_NAME.getVehicle();

        if (cursor2.moveToFirst()) {
            do {
                vehicleList.add(new Vehicle(
                        cursor2.getInt(0),
                        cursor2.getString(1),
                        cursor2.getInt(2),
                        cursor2.getString(3),
                        cursor2.getString(4)
                ));
            } while (cursor2.moveToNext());
            cursor2.close();
        }
        Cursor cursor3 = DATABASE_NAME.getCar();

        if (cursor3.moveToFirst()) {
            do {
                carList.add(new Car(
                        cursor3.getInt(0),
                        cursor3.getString(1),
                        cursor3.getInt(2),
                        cursor3.getString(3),
                        cursor3.getString(4),
                        cursor3.getString(5)
                ));
            } while (cursor3.moveToNext());
            cursor3.close();
        }

        Cursor cursor4 = DATABASE_NAME.getMotorcycle();

        if (cursor4.moveToFirst()) {
            do {
                motorcycleList.add(new Motorcycle(
                        cursor4.getInt(0),
                        cursor4.getString(1),
                        cursor4.getInt(2),
                        cursor4.getString(3),
                        cursor4.getString(4),
                        cursor4.getString(5)
                ));
            } while (cursor4.moveToNext());
            cursor4.close();
        }

        Cursor cursor5 = DATABASE_NAME.getProgrammer();

        if (cursor5.moveToFirst()) {
            do {
                programmerList.add(new Programmer(
                        cursor5.getString(0),
                        cursor5.getString(1),
                        cursor5.getInt(2),
                        cursor5.getDouble(3),
                        cursor5.getInt(4),
                        cursor5.getInt(5),
                        cursor5.getString(6),
                        cursor5.getInt(7)
                ));
            } while (cursor5.moveToNext());
            cursor5.close();
        }

        Cursor cursor6 = DATABASE_NAME.getManager();

        if (cursor6.moveToFirst()) {
            do {
                managerList.add(new Manager(
                        cursor6.getString(0),
                        cursor6.getString(1),
                        cursor6.getInt(2),
                        cursor6.getDouble(3),
                        cursor6.getInt(4),
                        cursor6.getInt(5),
                        cursor6.getString(6),
                        cursor6.getInt(7)
                ));
            } while (cursor6.moveToNext());
            cursor6.close();
        }

        Cursor cursor7 = DATABASE_NAME.getTester();

        if (cursor7.moveToFirst()) {
            do {
                testerList.add(new Tester(
                        cursor7.getString(0),
                        cursor7.getString(1),
                        cursor7.getInt(2),
                        cursor7.getDouble(3),
                        cursor7.getInt(4),
                        cursor7.getInt(5),
                        cursor7.getString(6),
                        cursor7.getInt(7)
                ));
            } while (cursor7.moveToNext());
            cursor7.close();
        }

        Cursor cursor8 = DATABASE_NAME.getAllEmployees();

        if (cursor8.moveToFirst()) {
            do {
                allEmployeestesterList.add(new Employee(
                        cursor8.getInt(0),
                        cursor8.getString(1),
                        cursor8.getString(2)
                ));
            } while (cursor8.moveToNext());
            cursor8.close();
        }


    }
        public void addEmployee (View view){
            Intent intent = new Intent(this, RegisterEmployee.class);
            startActivity(intent);
        }
    }




