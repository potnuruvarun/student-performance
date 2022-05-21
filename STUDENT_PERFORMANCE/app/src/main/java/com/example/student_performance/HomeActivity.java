package com.example.student_performance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    CardView Home;
//    CardView Profile;
    CardView Student;
    CardView Subject;
    CardView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Home = findViewById(R.id.Home);
//        Profile= findViewById(R.id.Profile);
        Student= findViewById(R.id.Student);
        Subject= findViewById(R.id.Subject);
        logout= findViewById(R.id.logout);

//        Home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showToast("Home Clicked");
//            }
//        });
//        Profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
//                startActivity(intent);
//            }
//        });
        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddStudent.class);
                startActivity(intent);
            }
        });
        Subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AddSubject.class);
                startActivity(intent);
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
