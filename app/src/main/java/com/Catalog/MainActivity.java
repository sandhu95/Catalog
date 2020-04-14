package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import  java.lang.String;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ListView listViewEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewEmployee = findViewById(R.id.listview);
        Catalog_singleton.getInstance().setEmployeeList(new ArrayList<Employee>());

        Catalog_singleton.getInstance().setmDatabase(new DataBaseHelper(this));

        Catalog_singleton.getInstance().getmDatabase().createTables(Catalog_singleton.getInstance().getmDatabase().getWritableDatabase());
        loadEmployees();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Catalog_singleton.getInstance().employeeList.clear();
        loadEmployees();
    }

    private   void loadEmployees() {

        Cursor cursor1 = Catalog_singleton.getInstance().getmDatabase().getAllEmployees();

        if (cursor1.moveToFirst()) {
            do {
                Catalog_singleton.getInstance().getEmployeeList().add(new Employee(
                        cursor1.getInt(0),
                        cursor1.getString(1),
                        cursor1.getString(2)
                ));
            } while (cursor1.moveToNext());
            cursor1.close();
        }

          EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, R.layout.list_layout_mainpage, Catalog_singleton.getInstance().getEmployeeList(), Catalog_singleton.getInstance().getmDatabase());
            listViewEmployee.setAdapter(employeeAdapter);
            employeeAdapter.notifyDataSetChanged();
        listViewEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               int empid = Catalog_singleton.getInstance().getEmployeeList().get(position).geteId();
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




