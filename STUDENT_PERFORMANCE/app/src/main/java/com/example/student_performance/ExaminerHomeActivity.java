package com.example.student_performance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ExaminerHomeActivity extends AppCompatActivity {

    CardView profile;
    CardView addmarks;
    CardView viewmarks;
    CardView sendmarks;
    CardView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examiner_home);

        profile = findViewById(R.id.profile);
        addmarks= findViewById(R.id.addmarks);
        viewmarks= findViewById(R.id.viewmarks);
//        sendmarks= findViewById(R.id.sendmarks);
        logout= findViewById(R.id.logout);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("profile Clicked");
            }
        });
        addmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("addmarks Clicked");
            }
        });
        viewmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("viewmarks Clicked");
            }
        });
        sendmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showToast("sendmarks Clicked");
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

