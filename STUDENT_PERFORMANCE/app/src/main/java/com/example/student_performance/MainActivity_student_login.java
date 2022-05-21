package com.example.student_performance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity_student_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student_login);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("student") && password.getText().toString().equals("student")){

                    //correct
                    Toast.makeText(MainActivity_student_login.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), StudentHomeActivity.class);
                    startActivity(intent);

                }else
                    //incorrect
                    Toast.makeText(MainActivity_student_login.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}

