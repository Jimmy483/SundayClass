package com.example.sundayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

            }
        });
    }
}
