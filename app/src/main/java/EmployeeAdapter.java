import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Catalog.DataBaseHelper;
import com.Catalog.Employee;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter {

    Context mContext;
    int layoutRes;
    List<Employee> employees;
    DataBaseHelper mDatabase;
    public EmployeeAdapter(Context mContext, int layoutRes, List<Employee> employees,DataBaseHelper mDatabase)
    {
        super(mContext, layoutRes, employees);
         this.mContext = mContext;
         this.layoutRes = layoutRes;
         this.employees =  employees;
         this.mDatabase = mDatabase;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
       return v;
    }
}