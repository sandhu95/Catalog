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
    List<Employee> vehicleList;
    List<Employee> carList;
    List<Employee> motorcycleList;
    List<Employee> programmerList;
    List<Employee> managerList;
    List<Employee> testerList;
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

        Cursor cursor = DATABASE_NAME.getAllEmployees();

        if (cursor.moveToFirst()) {
            do {
                employeeList.add(new Employee(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
            cursor.close();
        }

    }
        public void addEmployee (View view){
            Intent intent = new Intent(this, RegisterEmployee.class);
            startActivity(intent);
        }
    }




