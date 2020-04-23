package com.Catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import static android.view.View.GONE;
import static java.lang.Math.round;

public class Update_Employee extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    EditText firstName,lastName,birthYear,monthlySalary,occupationRate,projects,clients,
            bugs,vehicleModel,plateNumber;
    TextView clientsLabel, bugsLabel, projectsLabel, sideCarLabel,carTypeLabel,employeeID;
    Spinner employeeType,carTypeSpinner,vehicleColorSpinner;
    RadioGroup vehicleTypeRadioGroup,sideCarRadioGroup;
    RadioButton carRadioBtn,motorcycleRadioBtn,sidecarYesRadioBtn,sidecarNoRadioBtn;
    Button registerButton;
    Employee updatedEmp;
    Vehicle updatedVehicle;
    Car updatedCar;
    Motorcycle updatedMotorcycle;
    Programmer updatedProgrammer;
    Manager updatedManager;
    Tester updatedTester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__employee);

        Intent intent = getIntent();
        updatedEmp= (Employee) intent.getSerializableExtra("Employee");
        updatedVehicle= (Vehicle) intent.getSerializableExtra("Vehicle");
        updatedCar= (Car) intent.getSerializableExtra("Car");
        updatedMotorcycle= (Motorcycle) intent.getSerializableExtra("Motorcycle");
        updatedProgrammer= (Programmer) intent.getSerializableExtra("Programmer");
        updatedManager= (Manager) intent.getSerializableExtra("Manager");
        updatedTester= (Tester) intent.getSerializableExtra("Tester");

        firstName = findViewById(R.id.firstNameText);
        lastName = findViewById(R.id.lastNameText);
        birthYear = findViewById(R.id.birthYearText);
        monthlySalary = findViewById(R.id.monthlySalaryText);
        occupationRate = findViewById(R.id.occupationRateText);
        employeeID = findViewById(R.id.employeeIDText);
        employeeType = findViewById(R.id.employeeTypeSpinner);
        projectsLabel = findViewById(R.id.projectsLabel);
        projects = findViewById(R.id.projectsText);
        clientsLabel = findViewById(R.id.clientsLabel);
        clients = findViewById(R.id.clientsText);
        bugsLabel = findViewById(R.id.bugsLabel);
        bugs = findViewById(R.id.bugsText);
        vehicleTypeRadioGroup = findViewById(R.id.vehicleTypeRadioGroup);
        sideCarLabel = findViewById(R.id.SideCarLabel);
        sideCarRadioGroup = findViewById(R.id.SideCarRadioGroup);
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
                if (carRadioBtn.isChecked()) {
                    carTypeLabel.setVisibility(view.VISIBLE);
                    carTypeSpinner.setVisibility(view.VISIBLE);
                    sideCarLabel.setVisibility(GONE);
                    sideCarRadioGroup.setVisibility(GONE);
                }
            }
        });
        motorcycleRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (motorcycleRadioBtn.isChecked()) {
                    sideCarLabel.setVisibility(view.VISIBLE);
                    sideCarRadioGroup.setVisibility(view.VISIBLE);
                    carTypeLabel.setVisibility(GONE);
                    carTypeSpinner.setVisibility(GONE);
                }
            }
        });
        employeeType.setOnItemSelectedListener(this);


        firstName.setText(updatedEmp.getfName());
        lastName.setText(updatedEmp.getlName());
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthyr = currentYear- updatedEmp.getage();
        birthYear.setText(birthyr+"");
        monthlySalary.setText((round(updatedEmp.getSalary()/12.0))+"");
        occupationRate.setText(updatedEmp.getRate()+"");
        employeeID.setText(updatedEmp.geteId()+"");
            if(updatedEmp.geteType().equals("Manager"))
                employeeType.setSelection(1);
        else if(updatedEmp.geteType().equals("Tester"))
            employeeType.setSelection(2);
        else if(updatedEmp.geteType().equals("Programmer"))
            employeeType.setSelection(3);

        if(updatedCar.getType().equals("Sedan"))
                carTypeSpinner.setSelection(1);
        if(updatedCar.getType().equals("SUV"))
            carTypeSpinner.setSelection(2);
        if(updatedCar.getType().equals("Pickup Truck"))
            carTypeSpinner.setSelection(3);
        if(updatedCar.getType().equals("Sports"))
            carTypeSpinner.setSelection(4);
        if(updatedCar.getType().equals("Coupe"))
            carTypeSpinner.setSelection(5);
        if(updatedCar.getType().equals("Hatchback"))
            carTypeSpinner.setSelection(6);
        if(updatedCar.getType().equals("Convertible"))
            carTypeSpinner.setSelection(7);

        plateNumber.setText(updatedVehicle.getPlate());
        vehicleModel.setText(updatedVehicle.getModel());
        if(updatedEmp.geteType().equals("Tester"))
            bugs.setText(updatedTester.getNbBugs()+"");
        if(updatedEmp.geteType().equals("Programmer"))
         projects.setText(updatedProgrammer.getNbProjects()+"");
        if(updatedEmp.geteType().equals("Manager"))
         clients.setText(updatedManager.getNbclients()+"");

       if(updatedVehicle.getColor().equals("Red"))
           vehicleColorSpinner.setSelection(1);
       if(updatedVehicle.getColor().equals("Blue"))
           vehicleColorSpinner.setSelection(2);
       if(updatedVehicle.getColor().equals("Yellow"))
           vehicleColorSpinner.setSelection(3);
       if(updatedVehicle.getColor().equals("Green"))
           vehicleColorSpinner.setSelection(4);
       if(updatedVehicle.getColor().equals("Orange"))
           vehicleColorSpinner.setSelection(5);
       if(updatedVehicle.getColor().equals("Purple"))
           vehicleColorSpinner.setSelection(6);
       if(updatedVehicle.getColor().equals("Pink"))
           vehicleColorSpinner.setSelection(7);
       if(updatedVehicle.getColor().equals("Brown"))
           vehicleColorSpinner.setSelection(8);
       if(updatedVehicle.getColor().equals("White"))
           vehicleColorSpinner.setSelection(9);
       if(updatedVehicle.getColor().equals("Black"))
           vehicleColorSpinner.setSelection(10);
       if(updatedVehicle.getColor().equals("Beige"))
           vehicleColorSpinner.setSelection(11);


       if(updatedVehicle.getvType().equals("Car"))
           carRadioBtn.setChecked(true);
       if(updatedVehicle.getvType().equals("Motorcycle"))
           motorcycleRadioBtn.setChecked(true);
       if(updatedMotorcycle.getSideCar().equals("Yes"))
            sidecarYesRadioBtn.setChecked(true);
        else if(updatedMotorcycle.getSideCar().equals("No"))
            sidecarNoRadioBtn.setChecked(true);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (employeeType.getSelectedItem().toString().equals("Manager")) {
            clientsLabel.setVisibility(view.VISIBLE);
            clients.setVisibility(view.VISIBLE);
            bugsLabel.setVisibility(GONE);
            bugs.setVisibility(GONE);
            projectsLabel.setVisibility(GONE);
            projects.setVisibility(GONE);
        }
        if (employeeType.getSelectedItem().toString().equals("Tester")) {
            bugsLabel.setVisibility(view.VISIBLE);
            bugs.setVisibility(view.VISIBLE);
            projectsLabel.setVisibility(GONE);
            projects.setVisibility(GONE);
            clientsLabel.setVisibility(GONE);
            clients.setVisibility(GONE);
        }
        if (employeeType.getSelectedItem().toString().equals("Programmer")) {
            projectsLabel.setVisibility(view.VISIBLE);
            projects.setVisibility(view.VISIBLE);
            clientsLabel.setVisibility(GONE);
            clients.setVisibility(GONE);
            bugsLabel.setVisibility(GONE);
            bugs.setVisibility(GONE);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void addEmployee() {
        String fName = "N/A";

        if (!firstName.getText().toString().isEmpty())
            fName = firstName.getText().toString().trim();
        String lName="";

        if (lastName.getText().toString().isEmpty()) {
            lastName.setError("Required!");
            lastName.requestFocus();
            return;
        }

        lName = lastName.getText().toString().trim();


        if (birthYear.getText().toString().isEmpty()) {
            birthYear.setError("Birth Year can not be Empty!");
            birthYear.requestFocus();
            return;
        }
        int bYear = Integer.valueOf(birthYear.getText().toString());
        if (bYear < 1900 || bYear > 2020) {
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

        int oRate = 100;

        if (!occupationRate.getText().toString().isEmpty())
            oRate = Integer.valueOf(occupationRate.getText().toString());
        if (oRate > 100) {
            oRate = 100;
        } else if (oRate < 10) {
            oRate = 10;
        }
        double aSalary = 12 * mSalary * (oRate/100.0);

        if (employeeID.getText().toString().isEmpty()) {
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

        int numberofclients=0;
        if (eType.equals("Manager")) {

            int gainFactorClient = 500, gainFactorTravel = 100, numberofDaysTravelled = 24 * 12;

            if (clients.getText().toString().isEmpty()) {
                clients.setError("Enter clients made!");
                clients.requestFocus();
                return;
            }
            numberofclients = Integer.valueOf(clients.getText().toString());
            aSalary = aSalary + (gainFactorClient * numberofclients) + gainFactorTravel * numberofDaysTravelled;

        }
        int numberofbugs=0;
        if (eType.equals("Tester")) {
            int gainFactorError = 10;
            if (bugs.getText().toString().isEmpty()) {
                bugs.setError("Enter bugs solved!");
                bugs.requestFocus();
                return;
            }
            numberofbugs = Integer.valueOf(bugs.getText().toString());
            aSalary = aSalary + gainFactorError * numberofbugs;

        }
        int numberofprojects=0;
        if (eType.equals("Programmer")) {

            int gainFactorProjects = 200;
            if (projects.getText().toString().isEmpty()) {
                projects.setError("Enter projects Completed!");
                projects.requestFocus();
                return;
            }
            numberofprojects = Integer.valueOf(projects.getText().toString());
            aSalary = aSalary + gainFactorProjects * numberofprojects;
        }

        String vehicle = "N/A";
        String cType ="N/A";
        if (!carRadioBtn.isChecked() && !motorcycleRadioBtn.isChecked()) {
            Toast.makeText(this, "choose vehicle owned", Toast.LENGTH_SHORT).show();
            vehicleTypeRadioGroup.requestFocus();
            return;
        }
        if (carRadioBtn.isChecked()) {

            if (carTypeSpinner.getSelectedItem().toString().equals("Choose Type")) {
                Toast.makeText(this, "choose Car Type", Toast.LENGTH_SHORT).show();
                carTypeSpinner.requestFocus();
                return;
            }
            vehicle="Car";
            cType = carTypeSpinner.getSelectedItem().toString();
        }
        String sidecar = "N/A";
        if (motorcycleRadioBtn.isChecked()) {

            if (!sidecarNoRadioBtn.isChecked() && !sidecarYesRadioBtn.isChecked()) {
                Toast.makeText(this, "select Yes or No for sidecar!", Toast.LENGTH_SHORT).show();
                sideCarRadioGroup.requestFocus();
                return;
            }
            vehicle="Motorcycle";
            if (sidecarNoRadioBtn.isChecked()) {
                //Employee has motorcycle without a Side Car
                sidecar = "No";
            }
            if (sidecarYesRadioBtn.isChecked()) {
                //Employee has motorcycle with a Side Car
                sidecar = "Yes";
            }
        }


        if (vehicleModel.getText().toString().isEmpty()) {
            vehicleModel.setError("Enter make year!");
            vehicleModel.requestFocus();
            return;
        }
        String vModel = vehicleModel.getText().toString().trim();


        if (plateNumber.getText().toString().isEmpty()) {
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

        if (Catalog_singleton.getInstance().getmDatabase().updateallEmployees(empId,fName,lName)
                && Catalog_singleton.getInstance().getmDatabase().updateEmployee(empId,fName,lName,empAge,aSalary,oRate,eType)
                &&Catalog_singleton.getInstance().getmDatabase().updateMotorcycle(empId,sidecar)
                &&Catalog_singleton.getInstance().getmDatabase().updateCar(empId,cType)
                &&Catalog_singleton.getInstance().getmDatabase().updateVehicle(empId,vehicle,vModel,pNumber,vColor)
                &&Catalog_singleton.getInstance().getmDatabase().updateTester(empId,numberofbugs)
                &&Catalog_singleton.getInstance().getmDatabase().updateManager(empId,numberofclients)
                &&Catalog_singleton.getInstance().getmDatabase().updateProgrammer(empId, numberofprojects)) {
            Toast.makeText(this, "Employee Updated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Update_Employee.this, MainActivity.class);
            finishAffinity();
            startActivity(intent);

        } else
            Toast.makeText(this, "Employee not Updated", Toast.LENGTH_SHORT).show();
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
        bugsLabel.setVisibility(GONE);
        bugs.setVisibility(GONE);
        clientsLabel.setVisibility(GONE);
        clients.setVisibility(GONE);
        projectsLabel.setVisibility(GONE);
        projects.setVisibility(GONE);
        sideCarLabel.setVisibility(GONE);
        sideCarRadioGroup.setVisibility(GONE);
        carTypeLabel.setVisibility(GONE);
        carTypeSpinner.setVisibility(GONE);
        vehicleColorSpinner.setSelection(0);
        carRadioBtn.setChecked(false);
        motorcycleRadioBtn.setChecked(false);
        sidecarYesRadioBtn.setChecked(false);
        sidecarNoRadioBtn.setChecked(false);
    }
}
