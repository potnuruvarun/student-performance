package com.example.student_performance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button admin, staff, examiner, student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin = (Button) findViewById(R.id.adminbtn);
        staff = (Button) findViewById(R.id.employeebtn);
        examiner = (Button) findViewById(R.id.examinerbtn);
       student = (Button) findViewById(R.id.studentbtn);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //     Intent intent = new Intent(MainActivity.this, MainActivity_admin_login.class);
                Intent intent = new Intent(getApplicationContext(), MainActivity_admin_login.class);
                startActivity(intent);

            }
        });
//
//        staff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, MainActivity_staff_login.class);
////                startActivity(intent);
////            }
////        });

//        examiner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainActivity_examiner_login.class);
//                startActivity(intent);
//            }
//        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity_student_login.class);
                startActivity(intent);
            }
        });
    }
}