package com.example.sundayclass.model;

public class Employee {
    private int id;
    private String profile_image;
    private String employee_name;
    private float employee_salary;
    private int employee_age;

    public Employee(int id, String profile_image, String employee_name, Float employee_salary, int employee_age) {
        this.id = id;
        this.profile_image = profile_image;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Float getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Float employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

}
