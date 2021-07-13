package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sixthSubjectActivity extends AppCompatActivity {

    private static final String TAG = "sixthGradeActivity";
    private DatabaseHelper mDatabaseHelper;
    private Button addAssignmentBTN;
    private Button addGradeBTN;
    private TableLayout mTableLayout;
    private TableLayout upcomingTableLayout;
    private TextView gradeTV;
    private TextView targetGradeTV;
    private Button delBTN;
    private final String subject = "Sixth Subject";
    subject subjectObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_subject);
        mDatabaseHelper = new DatabaseHelper(this);
        addAssignmentBTN = findViewById(R.id.sixthSubAddAssignmentBTN);
        addGradeBTN = findViewById(R.id.sixthSubAddGradeBTN);
        mTableLayout =findViewById(R.id.sixthSubTableLayout);
        upcomingTableLayout =findViewById(R.id.sixthSubUpcomingTableLayout);
        gradeTV = findViewById(R.id.sixthSubGrade);
        targetGradeTV = findViewById(R.id.sixthSubTG);
        subjectObj = new subject(mDatabaseHelper);
        delBTN = findViewById(R.id.sixthSubDelBTN);


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

        delBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAssignment();
            }
        });
    }

    public String getLetterGrade() {
        Cursor data = mDatabaseHelper.getSixthSubjectData();
        String gpa =subjectObj.getLetterGrade(data);
        data.close();

        return gpa;
    }

    private void calculateGrade() {

        Cursor data = mDatabaseHelper.getSixthSubjectData();
        String gradeAverage =  subjectObj.getCalculatedGrade(data);
        data.close();
        gradeTV.setText(gradeAverage+"%");
    }

    public void deleteAssignment(){
        Intent intent = new Intent(this, deleteAssignment.class);
        intent.putExtra("subject",subject);
        startActivity(intent);
    }

    private void calculateTargetGrade() {

        Cursor data = mDatabaseHelper.getSixthSubjectData();
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
        Cursor data = mDatabaseHelper.getSixthSubjectData();
        subjectObj.populateUngradedAssignments(data,upcomingTableLayout,this);
        data.close();
    }

    private void populateGradedTable(){
        Cursor data = mDatabaseHelper.getSixthSubjectData();
        subjectObj.populateGradedTable(data, mTableLayout, this);
        data.close();
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}