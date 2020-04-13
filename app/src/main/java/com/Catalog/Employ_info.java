package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Employ_info extends AppCompatActivity {
    DataBaseHelper myDatabase;

    List<Employee> employeeList;
    List<Vehicle> vehicleList;
    List<Car> carList;
    List<Motorcycle> motorcycleList;
    List<Programmer> programmerList;
    List<Manager> managerList;
    List<Tester> testerList;

    TextView fname;
    TextView lname;
    TextView emp_Type;
    TextView vcolor;
    TextView age;
    TextView annualIncome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employ_info);

       Intent intent = getIntent();
        int EmpId = intent.getExtras().getInt("takeId");

        vehicleList = new ArrayList<>();
        employeeList = new ArrayList<>();
        carList = new ArrayList<>();
        motorcycleList = new ArrayList<>();
        programmerList = new ArrayList<>();
        managerList = new ArrayList<>();
        testerList = new ArrayList<>();

        fname = findViewById(R.id.fname_info);
        vcolor = findViewById(R.id.color_info);
        lname = findViewById(R.id.lname_info);
        emp_Type = findViewById(R.id.emp_type_info);
        age = findViewById(R.id.age_info);
        annualIncome = findViewById(R.id.annualincome_info);

        myDatabase = new DataBaseHelper(this);
        loadEmployees( EmpId);
    }
    private  void loadEmployees( int IdEmp){
        Cursor cursor1 = myDatabase.getEmployees(IdEmp);

        if (cursor1.moveToFirst()) {
            do {
                employeeList.add(new Employee(
                        cursor1.getInt(0),
                        cursor1.getString(1),
                        cursor1.getString(2),
                        cursor1.getInt(3),
                        cursor1.getDouble(4),
                        cursor1.getInt(5),
                        cursor1.getString(6)
                ));
            } while (cursor1.moveToNext());
            cursor1.close();
        }

        fname.setText(employeeList.get(0).getfName());
        lname.setText(employeeList.get(0).getlName());
        emp_Type.setText(employeeList.get(0).geteType());
        age.setText(employeeList.get(0).getage()+"");
        annualIncome.setText(employeeList.get(0).getSalary()+"");


        Cursor cursor2 = myDatabase.getVehicle(IdEmp);

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

      vcolor.setText(vehicleList.get(0).getColor());

    }
}
