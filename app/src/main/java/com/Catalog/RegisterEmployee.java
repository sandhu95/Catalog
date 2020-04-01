package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterEmployee extends AppCompatActivity{

    EditText firstName,lastName,birthYear,monthlySalary,occupationRate,employeeID,projects,clients,
    bugs,vehicleModel,plateNumber;
    Spinner  employeeType,carTypeSpinner,vehicleColorSpinner;
    RadioGroup vehicalTypeRadioGroup,sideCarRadioGroup;
    RadioButton  carRadioBtn,motorcycleRadioBtn,sidecarYesRadioBtn,sidecarNoRadioBtn;
    Button rgstrbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);

        firstName = findViewById(R.id.firstNameText);
        lastName = findViewById(R.id.lastNameText);
        birthYear= findViewById(R.id.birthYearText);
        monthlySalary= findViewById(R.id.monthlySalaryText);
        occupationRate  = findViewById(R.id.occupationRateText);
        employeeID  = findViewById(R.id.employeeIDText);
        employeeType = findViewById(R.id.employeeTypeSpinner);
        projects = findViewById(R.id.projectsText);
        clients = findViewById(R.id.clientsText);
        bugs = findViewById(R.id.bugsText);
        vehicalTypeRadioGroup=findViewById(R.id.vehicleTypeRadioGroup);
        sideCarRadioGroup=findViewById(R.id.SideCarRadioGroup);
        carRadioBtn = findViewById(R.id.carRadioButton);
        motorcycleRadioBtn = findViewById(R.id.motorcycleRadioButton);
        sidecarYesRadioBtn = findViewById(R.id.sidecarYesRadioButton);
        sidecarNoRadioBtn = findViewById(R.id.sidecarNoRadioButton);
        carTypeSpinner = findViewById(R.id.carTypeSpinner);
        vehicleModel = findViewById(R.id.vehicleModelText);
        plateNumber = findViewById(R.id.plateNumberText);
        vehicleColorSpinner = findViewById(R.id.vehicleColorSpinner);
        rgstrbtn = findViewById(R.id.registerButton);

        rgstrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });
    }

    private void addEmployee(){
        String fName ="";
        if(!firstName.getText().toString().isEmpty())
        fName = firstName.getText().toString().trim();

        String lName = lastName.getText().toString().trim();
        if (lName.isEmpty()) {
            lastName.setError("Required!");
            lastName.requestFocus();
            return;
        }

        if (birthYear.getText().toString().isEmpty()) {
            birthYear.setError("Birth Year can not be Empty!");
            birthYear.requestFocus();
            return;
        }
        int bYear= Integer.valueOf(birthYear.getText().toString());
        if(bYear<1900 || bYear>2020 ){
            birthYear.setError("Enter a valid Year!");
            birthYear.requestFocus();
            return;
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int empAge = currentYear - bYear;

        if (monthlySalary.getText().toString().isEmpty()) {
            monthlySalary.setError("Enter Salary!");
            monthlySalary.requestFocus();
            return;
        }
        double mSalary = Double.valueOf(monthlySalary.getText().toString());

        int oRate= 100;
        if(!occupationRate.getText().toString().isEmpty())
        oRate = Integer.valueOf(occupationRate.getText().toString());
        if(oRate>100){
            oRate=100;
        }
        else if(oRate<10){
            oRate=10;
        }
        double aSalary = 12 * mSalary * oRate;

        if(employeeID.getText().toString().isEmpty()){
            employeeID.setError("this field is mandatory!");
            employeeID.requestFocus();
            return;
        }
        int empId = Integer.valueOf(employeeID.getText().toString());

        if (employeeType.getSelectedItem().toString().equals("Choose a Type")) {
            Toast.makeText(this, "choose Employee Type", Toast.LENGTH_SHORT).show();
            employeeType.requestFocus();
            return;
        }
        String eType = employeeType.getSelectedItem().toString();
            if(eType.equals("Manager"))
            {
                //let us suppose each manager travels for 24 days in a month
                int gainFactorClient=500, gainFactorTravel=100, numberofDaysTravelled=24*12;
                int numberofclients=Integer.valueOf(clients.getText().toString());
                aSalary = aSalary + ( gainFactorClient* numberofclients) +  gainFactorTravel*numberofDaysTravelled;
            }
            if(eType.equals("Tester"))
            {
                int gainFactorError = 10;
                int numberofbugs=Integer.valueOf(clients.getText().toString());
                aSalary = aSalary + gainFactorError * numberofbugs;
            }
            if(eType.equals("Programmer"))
            {
                int gainFactorProjects = 200;
                int numberofprojects=Integer.valueOf(projects.getText().toString());
                aSalary = aSalary + gainFactorProjects * numberofprojects;
            }

        int empdId = Integer.valueOf(employeeID.getText().toString());
        if(carRadioBtn.isChecked())
         {
            String cType = carTypeSpinner.getSelectedItem().toString();
         }
        if(motorcycleRadioBtn.isChecked())
         {
             if(sidecarNoRadioBtn.isChecked())
                {
                    //Employee has motorcycle without a Side Car
                }
             if(sidecarYesRadioBtn.isChecked())
                {
                    //Employee has motorcycle with a Side Car
                }
         }

        int vModel= Integer.valueOf(vehicleModel.getText().toString());
        String pNumber = plateNumber.getText().toString().trim();
        String vColor = vehicleColorSpinner.getSelectedItem().toString().trim();

    }
    @Override
    protected void onRestart() {
        super.onRestart();

        firstName.setText("");
        lastName.setText("");
        birthYear.setText("");
        monthlySalary.setText("");
        occupationRate.setText("");
        employeeID.setText("");
        projects.setText("");
        clients.setText("");
        bugs.setText("");
        vehicleModel.setText("");
        plateNumber.setText("");
        employeeType.setSelection(0);
        carTypeSpinner.setSelection(0);
        vehicleColorSpinner.setSelection(0);
        carRadioBtn.setChecked(false);
        motorcycleRadioBtn.setChecked(false);
        sidecarYesRadioBtn.setChecked(false);
        sidecarNoRadioBtn.setChecked(false);
    }

}
