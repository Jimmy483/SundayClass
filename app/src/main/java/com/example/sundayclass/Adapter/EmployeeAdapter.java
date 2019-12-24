package com.example.sundayclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sundayclass.Employee1;
import com.example.sundayclass.R;
import com.example.sundayclass.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    Context mcontext;
    List<Employee1> employeeList;

    public EmployeeAdapter(Context mcontext, List<Employee1> employeeList) {
        this.mcontext = mcontext;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employeeview,parent,false);
        return new EmployeeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        Employee1 employee=employeeList.get(position);
        holder.id.setText(employee.getId());
        holder.salary.setText(employee.getSalary());
        holder.age.setText(employee.getAge());
        holder.name.setText(employee.getName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder
    {

        TextView id,name,age,salary;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.etId);
            name=itemView.findViewById(R.id.etName);
            age=itemView.findViewById(R.id.etAge);
            salary=itemView.findViewById(R.id.etSalary);

        }
    }





}
