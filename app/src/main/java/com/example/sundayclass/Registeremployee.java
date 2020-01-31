package com.example.sundayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sundayclass.api.EmployeeAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registeremployee extends AppCompatActivity {
    Button button;
    EditText name,salary,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeremployee);

        name=findViewById(R.id.txtName);
        salary=findViewById(R.id.txtSalary);
        age=findViewById(R.id.txtAge);
        button=findViewById(R.id.btnemployee);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register();
            }
        });
    }

    public void Register(){
        String nam=name.getText().toString();
        Float sal=Float.parseFloat(salary.getText().toString());
        int ag=Integer.parseInt(age.getText().toString());

        EmployeeCUD employeeCUD=new EmployeeCUD(nam,sal,ag);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory((GsonConverterFactory.create()))
                .build();

        EmployeeAPI employeeAPI =retrofit.create(EmployeeAPI.class);

        Call<Void> voidCall = employeeAPI.registerEmployee(employeeCUD);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(Registeremployee.this,"You have successfully registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(Registeremployee.this,"Error : " + t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
