package com.example.student_performance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class StudentHomeActivity extends AppCompatActivity {

    CardView profile;
    CardView attendance;
    CardView assignment;
    CardView courses;
    CardView reportcard;
    CardView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        profile = findViewById(R.id.profile);

        courses= findViewById(R.id.courses);
        reportcard= findViewById(R.id.repotcard);
        logout= findViewById(R.id.logout);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), StudentProfile.class);
//                startActivity(intent);

            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("attendance Clicked");
            }
        });
        assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("assignment Clicked");
            }
        });
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("courses Clicked");
            }
        });

        reportcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("reportcard Clicked");
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
    }
}
