package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class secondSubjectActivity extends AppCompatActivity {
    private static final String TAG = "secondGradeActivity";
    private DatabaseHelper mDatabaseHelper;
    private Button addAssignmentBTN;
    private Button addGradeBTN;
    private TableLayout mTableLayout;
    private TableLayout upcomingTableLayout;
    private TextView gradeTV;
    private TextView targetGradeTV;
    private final String subject = "Second Subject";
    subject subjectObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_subject);
        mDatabaseHelper = new DatabaseHelper(this);
        addAssignmentBTN = findViewById(R.id.secondSubAddAssignmentBTN);
        addGradeBTN = findViewById(R.id.secondSubAddGradeBTN);
        mTableLayout =findViewById(R.id.secondSubTableLayout);
        upcomingTableLayout =findViewById(R.id.secondSubUpcomingTableLayout);
        gradeTV = findViewById(R.id.secondSubGrade);
        targetGradeTV = findViewById(R.id.secondSubTG);
        subjectObj = new subject(mDatabaseHelper);

        populateUngradedAssignments();
        populateGradedTable();
        calculateGrade();
        calculateTargetGrade();

        addGradeBTN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addGrade();
            }
        });

        addAssignmentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAssignment();
            }
        });
    }

    public String getLetterGrade() {
        Cursor data = mDatabaseHelper.getSecondSubjectData();
        String gpa =subjectObj.getLetterGrade(data);
        data.close();

        return gpa;
    }

    private void calculateGrade() {

        Cursor data = mDatabaseHelper.getSecondSubjectData();
        double gradeAverage =  subjectObj.getCalculatedGrade(data);
        data.close();
        gradeTV.setText(String.valueOf(gradeAverage)+"%");
    }

    private void calculateTargetGrade() {

        Cursor data = mDatabaseHelper.getSecondSubjectData();
        String targetGradeAverage = subjectObj.getCalculateTargetGrade(data);
        data.close();
        targetGradeTV.setText(targetGradeAverage);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    private void addGrade() {
        Intent intent = new Intent(this,addGradeActivity.class );
        intent.putExtra("subject",subject);
        startActivity(intent);

    }


    public void addAssignment(){
        Intent intent = new Intent(this,addAssignmentActivity.class );
        intent.putExtra("subject",subject);
        startActivity(intent);
    }

    private void populateUngradedAssignments(){
        Cursor data = mDatabaseHelper.getSecondSubjectData();
        subjectObj.populateUngradedAssignments(data,upcomingTableLayout,this);
        data.close();
    }

    private void populateGradedTable(){
        Cursor data = mDatabaseHelper.getSecondSubjectData();
        subjectObj.populateGradedTable(data, mTableLayout, this);
        data.close();
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}