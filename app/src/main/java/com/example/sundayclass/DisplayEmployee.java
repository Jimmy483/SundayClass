package com.example.sundayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sundayclass.api.EmployeeAPI;
import com.example.sundayclass.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayEmployee extends AppCompatActivity {
    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_employee);

        out=findViewById(R.id.tvOutput);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);
        Call<List<Employee>> listCall=employeeAPI.getAllEmployees();
        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if(!response.isSuccessful()){

                    Toast.makeText(DisplayEmployee.this,"Code Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Employee> employeeList=response.body();
                for (Employee employee: employeeList){
                    String data="";
                    data +="Employee name : " + employee.getEmployee_name() + "\n";
                    data +="Employee age : " + employee.getEmployee_age() + "\n";
                    data +="Employee Salary : " + employee.getEmployee_salary() + "\n";
                    data +="-------------------------" + "\n";
                    out.append(data);
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

                Log.d("msg","onFailure: " + t.getLocalizedMessage());
                Toast.makeText(DisplayEmployee.this,"Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT);
            }
        });
    }
}
