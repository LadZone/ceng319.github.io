package com.instinctcoder.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentDetail extends ActionBarActivity implements android.view.View.OnClickListener {

    Button btnSave, btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextAge;
    private int _Student_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        btnSave = (Button) findViewById(R.id.btnSave);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        btnSave.setOnClickListener(this);


        _Student_Id = 0;
        Intent intent = getIntent();
        _Student_Id = intent.getIntExtra("student_Id", 0);
        StudentRepo repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_Student_Id);

        editTextAge.setText(String.valueOf(student.age));
        editTextName.setText(student.name);
        editTextEmail.setText(student.email);
    }


    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)) {
            StudentRepo repo = new StudentRepo(this);
            Student student = new Student();
            student.age = Integer.parseInt(editTextAge.getText().toString());
            student.email = editTextEmail.getText().toString();
            student.name = editTextName.getText().toString();
            student.student_ID = _Student_Id;

            if (_Student_Id == 0) {
                _Student_Id = repo.insert(student);

                Toast.makeText(this, "New Student Insert", Toast.LENGTH_SHORT).show();
            } else {

                repo.update(student);
                Toast.makeText(this, "Student Record updated", Toast.LENGTH_SHORT).show();
            }


        }

    }
}
