package com.example.sundayclass.api;

import com.example.sundayclass.EmployeeCUD;
import com.example.sundayclass.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {

    //get all employees
    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    //get employees by ID
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);

    //create

    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);

    //Update employee
    @PUT("update/{empID")
    Call<Void> updateEmployee(@Path("empID") int empId, @Body EmployeeCUD emp);

    //Delete
    @DELETE("delete/{empID}")
    Call<Void> deleteEmployee(@Path("empID") int empId);


}
