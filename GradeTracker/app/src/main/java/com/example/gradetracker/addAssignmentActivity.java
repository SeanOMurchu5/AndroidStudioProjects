package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
                double assignmentWeight = Double.parseDouble(etWeight.getText().toString());
                double assignmentTargetGrade =  Double.parseDouble(etTargetGrade.getText().toString());
                String assignmentSubject = subject;
                double assignmentGrade = 0;
                assignmentWeight = assignmentWeight/100;
                if((assignmentName.length() != 0 )&& (assignmentWeight != 0) && ((getTotalWeight(assignmentSubject)+assignmentWeight)<=1)){
                    addData(assignmentName,assignmentWeight, assignmentTargetGrade, assignmentSubject, assignmentGrade);
                }else{
                    toastMessage("you may have incorrectly input information (check if weights add up to 100");
                }
            }
        });
    }

    public void addData(String name, double weight, double targetGrade, String assignmentSubject, double assignmentGrade){
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

    public double getTotalWeight(String subject){
        double currentWeight=0;
        Cursor data = mDatabaseHelper.getData();
        if(data != null && data.moveToFirst()) {
            do {
                if(data.getString(4).equalsIgnoreCase(subject)) {
                    double newWeight = data.getDouble(2);
                    currentWeight += newWeight;
                }
            } while (data.moveToNext());
        }
        data.close();
        return currentWeight;
    }

}

