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

    List<Employee> employeeList;
    ListView listViewEmployee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewEmployee = findViewById(R.id.listview);
        employeeList = new ArrayList<>();

        Catalog_singleton.getInstance().setmDatabase(new DataBaseHelper(this));

        loadEmployees();
    }




    private void loadEmployees() {

        Cursor cursor1 = Catalog_singleton.getInstance().getmDatabase().getAllEmployees();

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

          EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, R.layout.list_layout_mainpage, employeeList, Catalog_singleton.getInstance().getmDatabase());
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

    }

        public void registerEmployee (View view){
            Intent intent = new Intent(this, RegisterEmployee.class);
            startActivity(intent);
        }


}




