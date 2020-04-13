package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import  java.lang.String;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DataBaseHelper myDatabase;
    List<Employee> employeeList;
    ListView listViewEmployee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewEmployee = findViewById(R.id.listview);
        employeeList = new ArrayList<>();

        myDatabase = new DataBaseHelper(this);
        loadEmployees();

    }


    private void loadEmployees() {

        Cursor cursor1 = myDatabase.getAllEmployees();

        if (cursor1.moveToFirst()) {
            do {
                employeeList.add(new Employee(
                        cursor1.getInt(0),
                        cursor1.getString(1),
                        cursor1.getString(2)
                ));
            } while (cursor1.moveToNext());
            cursor1.close();
        }

        EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, R.layout.list_layout_mainpage, employeeList, myDatabase);
        listViewEmployee.setAdapter(employeeAdapter);
        employeeAdapter.notifyDataSetChanged();
        listViewEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int empid = employeeList.get(position).geteId();
                Intent intent = new Intent(MainActivity.this, Employ_info.class);
                intent.putExtra("takeId", empid);
                startActivity(intent);

            }
        });

/*
        }

        Cursor cursor2 = myDatabase.getVehicle();

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

        Cursor cursor3 = myDatabase.getCar();

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
        Cursor cursor4 = myDatabase.getMotorcycle();

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

        Cursor cursor5 = myDatabase.getProgrammer();

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

        Cursor cursor6 = myDatabase.getManager();

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

        Cursor cursor7 = myDatabase.getTester();

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

        Cursor cursor8 = myDatabase.getAllEmployees();

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
*/
    }

    public void registerEmployee (View view){
        Intent intent = new Intent(this, RegisterEmployee.class);
        startActivity(intent);
    }


}




