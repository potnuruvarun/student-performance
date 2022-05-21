package com.example.student_performance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubject extends AppCompatActivity {

    EditText subname, basket, credit, semester;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        subname = findViewById(R.id.subname);
        basket = findViewById(R.id.basket);
        credit = findViewById(R.id.credit);
        semester = findViewById(R.id.semester);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subnameTXT = subname.getText().toString();
                String basketTXT = basket.getText().toString();
                String creditTXT = credit.getText().toString();
                String semesterTXT = semester.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(subnameTXT, basketTXT, creditTXT, semesterTXT);
                if(checkinsertdata==true)
                    Toast.makeText(AddSubject.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddSubject.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subnameTXT = subname.getText().toString();
                String basketTXT = basket.getText().toString();
                String creditTXT = credit.getText().toString();
                String semesterTXT = semester.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(subnameTXT, basketTXT, creditTXT, semesterTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AddSubject.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddSubject.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subnameTXT = subname.getText().toString();
                Boolean checkudeletedata = DB.deletedata(subnameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(AddSubject.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddSubject.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(AddSubject.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("SubName :"+res.getString(0)+"\n");
                    buffer.append("Basket :"+res.getString(1)+"\n");
                    buffer.append("Credit :"+res.getString(2)+"\n\n");
                    buffer.append("Semester :"+res.getString(3)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AddSubject.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}
