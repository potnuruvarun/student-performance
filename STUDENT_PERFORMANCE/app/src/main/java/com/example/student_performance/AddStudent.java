package com.example.student_performance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText etName,etGender,etEmail,etPhone,etDob,etBloodGroup,etsemester,etDepartment,etId;
    Button addBtn;
    Button vBtn;
    Button updateBtn;
    Button delBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        myDb=new  DatabaseHelper(this);
        etName=(EditText)findViewById(R.id.etName);
        etGender=(EditText)findViewById(R.id.etGender);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etDob=(EditText)findViewById(R.id.etDob);
        etBloodGroup=(EditText)findViewById(R.id.etBloodGroup);
        etsemester=(EditText)findViewById(R.id.etsemester);
        etDepartment=(EditText)findViewById(R.id.etDepartment);
        addBtn=(Button) findViewById(R.id.registerBtn);
        vBtn=(Button) findViewById(R.id.viewBtn);
        //    updateBtn=(Button) findViewById(R.id.updatebtn);
        //    delBtn=(Button) findViewById(R.id.deletebtn);
        addData();
        viewData();
        //    updateData();
        //    dellData();
    }
    public void addData()
    {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted= myDb.insertData( etName.getText().toString(),
                        etGender.getText().toString(),
                        etEmail.getText().toString(),
//                        etPassword.getText().toString(),
                        etPhone.getText().toString(),
                        etDob.getText().toString(),
                        etBloodGroup.getText().toString(),
                        etsemester.getText().toString(),
                        etDepartment.getText().toString()
                );
                if(isInserted==true)
                    Toast.makeText(AddStudent.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddStudent.this,"Data  not Inserted",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void viewData()
    {
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getData();
                if (res.getCount() == 0) {
                    //show message
                    showMsg("Error","No data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("NAME :" + res.getString(1) + "\n");
                    buffer.append("GENDER :" + res.getString(2) + "\n");
                    buffer.append("EMAIL :" + res.getString(3) + "\n");

                    buffer.append("PHONE :" + res.getString(5) + "\n");
                    buffer.append("DOB :" + ((Cursor) res).getString(6) + "\n");
                    buffer.append("BLOOD GROUP :" + res.getString(7) + "\n");
                    buffer.append("SEMESTER :" + res.getString(8) + "\n");
                    buffer.append("DEPARTMENT :" + res.getString(9) + "\n\n");
                }
                //show alldata
                showMsg("Data",buffer.toString());
            }
        });
    }
    public void showMsg(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


 /*       public void dellData()
        {
            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int delRows=myDb.delData( etId.getText().toString());
                    if(delRows>0)
                        Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"Data  not Deleted",Toast.LENGTH_LONG).show();


                }
            });
        }

  */
 /*      public void updateData()
        {
            updateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdate=myDb.updateData( etId.getText().toString(),
                            etName.getText().toString(),
                            etGender.getText().toString(),
                            etEmail.getText().toString());
                    if(isUpdate==true)
                        Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"Data  not Updated",Toast.LENGTH_LONG).show();

                }
            });
        }

  */

}
