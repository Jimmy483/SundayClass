package com.example.sundayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class UpdateDeleteEmployee extends AppCompatActivity implements View.OnClickListener {
    Button btnSearch,btnUpdate,btnDelete;
    EditText number,Name,Age;

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


        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btnSearchEmp:
                break;
            case R.id.btnEmpUpdate:
                break;
            case R.id.btnDelete:
                break;
        }
    }
}
