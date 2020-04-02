package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;



public class RegisterEmployee extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DataBaseHelper mDatabase;

    EditText firstName,lastName,birthYear,monthlySalary,occupationRate,employeeID,projects,clients,
    bugs,vehicleModel,plateNumber;
    TextView clientsLabel, bugsLabel, projectsLabel, sideCarLabel,carTypeLabel;
    Spinner  employeeType,carTypeSpinner,vehicleColorSpinner;
    RadioGroup vehicleTypeRadioGroup,sideCarRadioGroup;
    RadioButton  carRadioBtn,motorcycleRadioBtn,sidecarYesRadioBtn,sidecarNoRadioBtn;
    Button registerButton;

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
        projectsLabel = findViewById(R.id.projectsLabel);
        projects = findViewById(R.id.projectsText);
        clientsLabel = findViewById(R.id.clientsLabel);
        clients = findViewById(R.id.clientsText);
        bugsLabel = findViewById(R.id.bugsLabel);
        bugs = findViewById(R.id.bugsText);
        vehicleTypeRadioGroup=findViewById(R.id.vehicleTypeRadioGroup);
        sideCarLabel = findViewById(R.id.SideCarLabel);
        sideCarRadioGroup=findViewById(R.id.SideCarRadioGroup);
        carTypeLabel = findViewById(R.id.carTypeLabel);
        carRadioBtn = findViewById(R.id.carRadioButton);
        motorcycleRadioBtn = findViewById(R.id.motorcycleRadioButton);
        sidecarYesRadioBtn = findViewById(R.id.sidecarYesRadioButton);
        sidecarNoRadioBtn = findViewById(R.id.sidecarNoRadioButton);
        carTypeSpinner = findViewById(R.id.carTypeSpinner);
        vehicleModel = findViewById(R.id.vehicleModelText);
        plateNumber = findViewById(R.id.plateNumberText);
        vehicleColorSpinner = findViewById(R.id.vehicleColorSpinner);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmployee();
            }
        });
        carRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carRadioBtn.isChecked()){
                    carTypeLabel.setVisibility(view.VISIBLE);
                    carTypeSpinner.setVisibility(view.VISIBLE);
                    sideCarLabel.setVisibility(view.GONE);
                    sideCarRadioGroup.setVisibility(view.GONE);
                }
            }
        });
        motorcycleRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(motorcycleRadioBtn.isChecked()){
                    sideCarLabel.setVisibility(view.VISIBLE);
                    sideCarRadioGroup.setVisibility(view.VISIBLE);
                     carTypeLabel.setVisibility(view.GONE);
                     carTypeSpinner.setVisibility(view.GONE);
                }
            }
        });
        employeeType.setOnItemSelectedListener(this);

        mDatabase = new DataBaseHelper(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (employeeType.getSelectedItem().toString().equals("Manager")) {
                    clientsLabel.setVisibility(view.VISIBLE);
                    clients.setVisibility(view.VISIBLE);
                    bugsLabel.setVisibility(view.GONE);
                    bugs.setVisibility(view.GONE);
                    projectsLabel.setVisibility(view.GONE);
                    projects.setVisibility(view.GONE);
                }
                if (employeeType.getSelectedItem().toString().equals("Tester")) {
                    bugsLabel.setVisibility(view.VISIBLE);
                    bugs.setVisibility(view.VISIBLE);
                    projectsLabel.setVisibility(view.GONE);
                    projects.setVisibility(view.GONE);
                    clientsLabel.setVisibility(view.GONE);
                    clients.setVisibility(view.GONE);
                }
                if (employeeType.getSelectedItem().toString().equals("Programmer")) {
                    projectsLabel.setVisibility(view.VISIBLE);
                    projects.setVisibility(view.VISIBLE);
                    clientsLabel.setVisibility(view.GONE);
                    clients.setVisibility(view.GONE);
                    bugsLabel.setVisibility(view.GONE);
                    bugs.setVisibility(view.GONE);
                }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
            if(clients.getText().toString().isEmpty()){
                clients.setError("Enter clients made!");
                clients.requestFocus();
                return;
            }
            int numberofclients=Integer.valueOf(clients.getText().toString());
            aSalary = aSalary + ( gainFactorClient* numberofclients) +  gainFactorTravel*numberofDaysTravelled;

        }
        if(eType.equals("Tester"))
        {
            int gainFactorError = 10;
            if(bugs.getText().toString().isEmpty()){
                bugs.setError("Enter bugs solved!");
                bugs.requestFocus();
                return;
            }
            int numberofbugs=Integer.valueOf(bugs.getText().toString());
            aSalary = aSalary + gainFactorError * numberofbugs;
        }
        if(eType.equals("Programmer")) {
            int gainFactorProjects = 200;
            if(projects.getText().toString().isEmpty()){
                projects.setError("Enter projects Completed!");
                projects.requestFocus();
                return;
            }
            int numberofprojects=Integer.valueOf(projects.getText().toString());
            aSalary = aSalary + gainFactorProjects * numberofprojects;
        }

        if(!carRadioBtn.isChecked()&&!motorcycleRadioBtn.isChecked()){
            Toast.makeText(this, "choose vehicle owned", Toast.LENGTH_SHORT).show();
            vehicleTypeRadioGroup.requestFocus();
            return;
        }
        if(carRadioBtn.isChecked())
         {
             if (carTypeSpinner.getSelectedItem().toString().equals("Choose Type"))
             {
                 Toast.makeText(this, "choose Car Type", Toast.LENGTH_SHORT).show();
                 carTypeSpinner.requestFocus();
                 return;
             }
            String cType = carTypeSpinner.getSelectedItem().toString();
         }
        String sidecar="";
        if(motorcycleRadioBtn.isChecked())
         {
             if(!sidecarNoRadioBtn.isChecked()&&!sidecarYesRadioBtn.isChecked()){
                 Toast.makeText(this, "select Yes or No for sidecar!", Toast.LENGTH_SHORT).show();
                 sideCarRadioGroup.requestFocus();
                 return;
             }
             if(sidecarNoRadioBtn.isChecked())
                {
                    //Employee has motorcycle without a Side Car
                    sidecar="No";
                }
             if(sidecarYesRadioBtn.isChecked())
                {
                    //Employee has motorcycle with a Side Car
                    sidecar = "Yes";
                }
         }
        if(vehicleModel.getText().toString().isEmpty()){
            vehicleModel.setError("Enter make year!");
            vehicleModel.requestFocus();
            return;
        }
        int vModel= Integer.valueOf(vehicleModel.getText().toString());

        if(plateNumber.getText().toString().isEmpty()){
            plateNumber.setError("enter vehicle plate!");
            plateNumber.requestFocus();
            return;
        }
        String pNumber = plateNumber.getText().toString().trim();

        if (vehicleColorSpinner.getSelectedItem().toString().equals("Choose a Color")) {
            Toast.makeText(this, "choose color of Vehicle", Toast.LENGTH_SHORT).show();
            vehicleColorSpinner.requestFocus();
            return;
        }
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
