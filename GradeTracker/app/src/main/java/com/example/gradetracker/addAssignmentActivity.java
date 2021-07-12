package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addAssignmentActivity extends AppCompatActivity{
    DatabaseHelper mDatabaseHelper;
    private Button addAssignment;
    private EditText etName;
    private EditText etWeight;
    private EditText etTargetGrade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);
        mDatabaseHelper = new DatabaseHelper(this);
        etName =(EditText) findViewById(R.id.newAssignmentText);
        etWeight =(EditText) findViewById(R.id.newWeightText);
        etTargetGrade =(EditText) findViewById(R.id.newTargetGradeText);
        String subject;
            Bundle extras = getIntent().getExtras();
            subject= extras.getString("subject");

        addAssignment = (Button)findViewById(R.id.firstSubAddAssignmentBTN);
        addAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String assignmentName = etName.getText().toString() ;
                String assignmentWeight = etWeight.getText().toString();
                String assignmentTargetGrade = etTargetGrade.getText().toString();
                String assignmentSubject = subject;
                String assignmentGrade = "";

                if(assignmentName.length() != 0 && assignmentWeight.length() != 0 && assignmentTargetGrade.length() != 0){
                    addData(assignmentName,assignmentWeight,assignmentTargetGrade, assignmentSubject, assignmentGrade);
                }else{
                    toastMessage("you have to put something in the text fields");
                }
            }
        });
    }

    public void addData(String name, String weight, String targetGrade, String assignmentSubject,String assignmentGrade){
       boolean insertData = mDatabaseHelper.addData(name, weight, targetGrade, assignmentSubject, assignmentGrade);
       if(insertData){
           toastMessage("data successfully inserted!");
       }else{
           toastMessage("insertion failed");
       }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}

