package com.example.sundayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
Button btnShow,btnRegister,btnSearch,btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow=findViewById(R.id.btnShow);
        btnRegister=findViewById(R.id.btnRegister);
        btnSearch=findViewById(R.id.btnSearch);
        btnUpdate=findViewById(R.id.btnUpdate);

        btnShow.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnSearch.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnShow:
                Intent showintent=new Intent(MainActivity.this,DisplayEmployee.class);
                startActivity(showintent);
                break;

            case R.id.btnRegister:
                Intent registerintent=new Intent(MainActivity.this,Registeremployee.class);
                startActivity(registerintent);
                break;

            case R.id.btnSearch:
                Intent searchintent=new Intent(MainActivity.this,SearchEmployee.class);
                startActivity(searchintent);
                break;

            case R.id.btnUpdate:
                Intent updateintent=new Intent(MainActivity.this,UpdateDeleteEmployee.class);
                startActivity(updateintent);
                break;
        }


    }
}
