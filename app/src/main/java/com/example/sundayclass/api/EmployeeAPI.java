package com.example.sundayclass.api;

import com.example.sundayclass.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeAPI {

    //get all employees
    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    //get employees by ID
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);


}
