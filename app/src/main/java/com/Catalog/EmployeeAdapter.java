package com.Catalog;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter {

    Context mContext;
    int layoutRes;
    List<Employee> employees;

    public EmployeeAdapter(Context mContext, int layoutRes, List<Employee> employees,DataBaseHelper mDatabase)
    {
        super(mContext, layoutRes, employees);
         this.mContext = mContext;
         this.layoutRes = layoutRes;
         this.employees =  employees;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
        TextView firstName = v.findViewById(R.id.list_fname);
        TextView lastName= v.findViewById(R.id.list_lname);
        TextView idInList = v.findViewById(R.id.list_id);

        final Employee employee = employees.get(position);
        firstName.setText(employee.getfName());
        lastName.setText(String.valueOf(employee.getlName()));
        idInList.setText(employee.geteId()+"");

       return v;
    }





}