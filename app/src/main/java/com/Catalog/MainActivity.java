package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class
MainActivity extends AppCompatActivity
{
    private static final String TAG = "EmployeeActivity";
    DataBaseHelper Database;
    List<Employee> employeeList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        employeeList = new ArrayList<>();
        Database = new DataBaseHelper(this);

    }
    public void addEmployee(View view){
        Intent intent = new Intent(this, RegisterEmployee.class);
        startActivity(intent);
    }
}
