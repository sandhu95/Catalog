package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;

public class Employ_info extends AppCompatActivity {


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
    TextView age;
    TextView annualIncome;
    TextView occupationRate;
    TextView vehicleType;
    TextView model;
    TextView plate;
    TextView vcolor;
    TextView setempType;
    TextView sidecar;
    TextView cartype;
    TextView cartxt;
    TextView motorcycletxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employ_info);

       Intent intent = getIntent();
        final int EmpId = intent.getExtras().getInt("takeId");

        vehicleList = new ArrayList<>();
        employeeList = new ArrayList<>();
        carList = new ArrayList<>();
        motorcycleList = new ArrayList<>();
        programmerList = new ArrayList<>();
        managerList = new ArrayList<>();
        testerList = new ArrayList<>();

        fname = findViewById(R.id.fname_info);
        lname = findViewById(R.id.lname_info);
        emp_Type = findViewById(R.id.emp_type_info);
        age = findViewById(R.id.age_info);
        annualIncome = findViewById(R.id.annualincome_info);
        occupationRate = findViewById(R.id.occupationrate_info);
        setempType = findViewById(R.id.clients_bugs_projects_info);

        vehicleType = findViewById(R.id.vehicle_info);
        model = findViewById(R.id.model_info);
        plate = findViewById(R.id.plate_info);
        vcolor = findViewById(R.id.color_info);
        sidecar = findViewById(R.id.sidecar_info);
        cartype = findViewById(R.id.cartype_info);
        cartxt = findViewById(R.id.cartype_info_label);
        motorcycletxt = findViewById(R.id.sidecar_info_label);



        loadEmployees( EmpId);
        findViewById(R.id.deleteEmployee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEmployee(EmpId);
            }
        });

    }
   private  void loadEmployees( int IdEmp){
        Cursor cursor1 = Catalog_singleton.getInstance().getmDatabase().getEmployees(IdEmp);

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
        occupationRate.setText(employeeList.get(0).getRate()+"");

        Cursor cursor5 = Catalog_singleton.getInstance().getmDatabase().getProgrammer(IdEmp);

        if (cursor5.moveToFirst()) {
            do {
                programmerList.add(new Programmer(
                        cursor5.getInt(0),
                        fname.getText().toString(),
                        lname.getText().toString(),
                        Integer.valueOf(age.getText().toString()),
                        Double.valueOf(annualIncome.getText().toString()),
                        Integer.valueOf(occupationRate.getText().toString()),
                        emp_Type.getText().toString(),
                        Integer.valueOf(cursor5.getString(1))
                ));
            } while (cursor5.moveToNext());
            cursor5.close();
        }


        Cursor cursor6 = Catalog_singleton.getInstance().getmDatabase().getTester(IdEmp);

        if (cursor6.moveToFirst()) {
            do {
                testerList.add(new Tester(
                        IdEmp,
                        fname.getText().toString(),
                        lname.getText().toString(),
                        Integer.valueOf(age.getText().toString()),
                        Double.valueOf(annualIncome.getText().toString()),
                        Integer.valueOf(occupationRate.getText().toString()),
                        emp_Type.getText().toString(),
                        Integer.valueOf(cursor6.getString(1))
                ));
            } while (cursor6.moveToNext());
            cursor6.close();
        }



    Cursor cursor7 = Catalog_singleton.getInstance().getmDatabase().getManager(IdEmp);

    if (cursor7.moveToFirst()) {
        do {
            managerList.add(new Manager(
                    cursor7.getInt(0),
                    fname.getText().toString(),
                    lname.getText().toString(),
                    Integer.valueOf(age.getText().toString()),
                    Double.valueOf(annualIncome.getText().toString()),
                    Integer.valueOf(occupationRate.getText().toString()),
                    emp_Type.getText().toString(),
                    Integer.valueOf(cursor7.getString(1))
            ));
        } while (cursor7.moveToNext());
        cursor7.close();
    }

        int projects = programmerList.get(0).getNbProjects();
        int bugs = testerList.get(0).getNbBugs();
       int clients = managerList.get(0).getNbclients();
        if(employeeList.get(0).geteType().equals("Manager"))
        {
            setempType.setText(" brought "+clients+" Clients");
        }
        if(employeeList.get(0).geteType().equals("Tester"))
        {
            setempType.setText(" Corrected  "+bugs+" Bugs");
        }
        if(employeeList.get(0).geteType().equals("Programmer"))
        {
            setempType.setText(" completed "+projects+" Projects");
        }




        Cursor cursor2 = Catalog_singleton.getInstance().getmDatabase().getVehicle(IdEmp);

        if (cursor2.moveToFirst()) {
            do {
                vehicleList.add(new Vehicle(
                        cursor2.getInt(0),
                        cursor2.getString(1),
                        cursor2.getString(2),
                        cursor2.getString(3),
                        cursor2.getString(4)
                ));
            } while (cursor2.moveToNext());
            cursor2.close();
        }

        vehicleType.setText(vehicleList.get(0).getvType());
        model.setText(vehicleList.get(0).getModel());
        plate.setText(vehicleList.get(0).getPlate());
        vcolor.setText(vehicleList.get(0).getColor());
        if(vehicleType.getText().toString().equals("Car"))
        {
            cartype.setVisibility(VISIBLE);
            cartxt.setVisibility(VISIBLE);

        }
        if(vehicleType.getText().toString().equals("Motorcycle"))
        {
            motorcycletxt.setVisibility(VISIBLE);
            sidecar.setVisibility(VISIBLE);
        }

        Cursor cursor3 = Catalog_singleton.getInstance().getmDatabase().getMotorcycle(IdEmp);

        if (cursor3.moveToFirst()) {
            do {
                motorcycleList.add(new Motorcycle(
                        IdEmp,
                        cursor3.getString(1),
                        vehicleType.getText().toString(),
                        model.getText().toString(),
                        plate.getText().toString(),
                        vcolor.getText().toString()
                ));
            } while (cursor3.moveToNext());
            cursor3.close();
        }
        if(motorcycleList.get(0).getSideCar().equals("Yes"))
            sidecar.setText("With");
        else
            sidecar.setText("Without");

       Cursor cursor4 = Catalog_singleton.getInstance().getmDatabase().getCar(IdEmp);

        if (cursor4.moveToFirst()) {
            do {
                carList.add(new Car(
                        cursor4.getInt(0),
                       vehicleType.getText().toString(),
                        model.getText().toString(),
                        plate.getText().toString(),
                        vcolor.getText().toString(),
                        cursor4.getString(1)

                ));
            } while (cursor4.moveToNext());
            cursor4.close();
        }
        cartype.setText(carList.get(0).getType());
    }

    private void deleteEmployee(final int emplId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (Catalog_singleton.getInstance().getmDatabase().deleteEmployee(emplId)) {
                    Toast.makeText(Employ_info.this, "Employee Deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Employ_info.this, MainActivity.class);

                    // to delete the view of this activity
                    finishAffinity();
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
