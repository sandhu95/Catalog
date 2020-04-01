package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterEmployee extends AppCompatActivity {

    EditText firstName,lastName,birthYear,monthlySalary,occupationRate,employeeID,projects,clients,
    bugs,vehicleModel,plateNumber;
    Spinner  employeeType,carTypeSpinner,vehicleColorSpinner;
    RadioGroup vehicalTypeRadioGroup,sideCarRadioGroup;
    RadioButton  carRadioBtn,motorcycleRadioBtn,sidecarYesRadioBtn,sidecarNoRadioBtn;

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


    }
    private void addEmployee()  {
        String fName = firstName.getText().toString().trim();
        String lName = lastName.getText().toString().trim();
        int bYear= Integer.valueOf(birthYear.getText().toString());
        double mSalary = Double.valueOf(monthlySalary.getText().toString());
        int oRate= Integer.valueOf(occupationRate.getText().toString());
        String eType = employeeType.getSelectedItem().toString().trim();

        if(carRadioBtn.isChecked())
         {
            String cType = carTypeSpinner.getSelectedItem().toString();
         }
        if(motorcycleRadioBtn.isChecked())
         {
             if(sidecarNoRadioBtn.isChecked())
                {
                    //Employee has motocycle without a Side Car
                }
             if(sidecarYesRadioBtn.isChecked())
                {
                    //Employee has motocycle with a Side Car
                }
         }

        int vModel= Integer.valueOf(vehicleModel.getText().toString());
        String pNumber = plateNumber.getText().toString().trim();
        String vColor = vehicleColorSpinner.getSelectedItem().toString().trim();
    }




}
