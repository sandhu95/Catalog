package com.Catalog;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter  implements Filterable {


    Context mContext;
    int layoutRes;
    List<Employee> employees;
    List<Employee> filterList;
    CustomFilter filter;

    public EmployeeAdapter(Context mContext, int layoutRes, List<Employee> employees,DataBaseHelper mDatabase)
    {
        super(mContext, layoutRes, employees);
         this.mContext = mContext;
         this.layoutRes = layoutRes;
         this.employees =  employees;
         this.filterList = employees;

    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return employees.indexOf(getItem(position));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

           LayoutInflater inflater = LayoutInflater.from(mContext);

           if(convertView==null){
               convertView = inflater.inflate(layoutRes,null);
           }

            TextView firstName = convertView.findViewById(R.id.list_fname);
            TextView lastName = convertView.findViewById(R.id.list_lname);
            TextView idInList = convertView.findViewById(R.id.list_id);

            if (employees.size() > position) {

                final Employee employee = employees.get(position);
                firstName.setText(employee.getfName());
                lastName.setText(String.valueOf(employee.getlName()));
                idInList.setText(employee.geteId() + "");

            }

           return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if(filter == null){
            filter= new CustomFilter();
        }
        return filter;
    }

    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if(!(constraint == null )&&constraint.length()>0){
                constraint = constraint.toString().toUpperCase();
                List<Employee> filters = new ArrayList<Employee>();

                for(int i=0 ;i< filterList.size();i++){
                    if(filterList.get(i).getfName().toUpperCase().contains(constraint)||filterList.get(i).getlName().toUpperCase().contains(constraint)){
                        Employee nEmp = new Employee(filterList.get(i).geteId(),filterList.get(i).getfName(),filterList.get(i).getlName());
                        filters.add(nEmp);
                    }
                }
                results.count = filters.size();
                results.values = filters;
             }else {
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            employees=(List<Employee>) results.values;

            notifyDataSetChanged();
            }
    }
}