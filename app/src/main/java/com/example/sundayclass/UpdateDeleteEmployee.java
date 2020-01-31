package com.example.sundayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sundayclass.api.EmployeeAPI;
import com.example.sundayclass.model.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateDeleteEmployee extends AppCompatActivity implements View.OnClickListener {
    Button btnSearch,btnUpdate,btnDelete;
    EditText number,Name,Age,Salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_employee);

        btnSearch=findViewById(R.id.btnSearchEmp);
        btnUpdate=findViewById(R.id.btnEmpUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        number=findViewById(R.id.txtEmpNo);
        Name=findViewById(R.id.txtempName);
        Age=findViewById(R.id.txtEmpAge);
        Salary=findViewById(R.id.txtEmpSalary);


        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btnSearchEmp:
                loadData();
                break;
            case R.id.btnEmpUpdate:
                updateEmployee();
                break;
            case R.id.btnDelete:
                deleteEmployee();
                break;
        }
    }



    /*private void CreateInstance()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);
    }*/

    private void loadData()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);
        Call<Employee> listCall=employeeAPI.getEmployeeByID(Integer.parseInt(number.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Name.setText(response.body().getEmployee_name());
                number.setText(Integer.toString(response.body().getId()));
                Salary.setText(Float.toString(response.body().getEmployee_salary()));
                Age.setText(Integer.toString(response.body().getEmployee_age()));
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {

                Toast.makeText(UpdateDeleteEmployee.this,"Error" + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void deleteEmployee()
    {


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);
        Call<Void> voidCall=employeeAPI.deleteEmployee(Integer.parseInt(number.getText().toString()));

        voidCall.enqueue((new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateDeleteEmployee.this,"Successfully deleted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateDeleteEmployee.this,"Error" + t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        }));
    }

    private void updateEmployee()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EmployeeAPI employeeAPI=retrofit.create(EmployeeAPI.class);
        EmployeeCUD employeeCUD=new EmployeeCUD(
                Name.getText().toString(),
                Float.parseFloat(Salary.getText().toString()),
                Integer.parseInt(Age.getText().toString()));



        //Call<Void> voidcall=employeeAPI.updateEmployee(Integer.parseInt(number.getText().toString()),employeeCUD);
        Call<Void> voidCall=employeeAPI.updateEmployee(Integer.parseInt(number.getText().toString()),employeeCUD);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Toast.makeText(UpdateDeleteEmployee.this,"Updated",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(UpdateDeleteEmployee.this,"Error" + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
