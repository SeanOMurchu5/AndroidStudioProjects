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

public class fifthSubjectActivity extends AppCompatActivity {

    private static final String TAG = "fifthGradeActivity";
    private DatabaseHelper mDatabaseHelper;
    private Button addAssignmentBTN;
    private Button addGradeBTN;
    private TableLayout mTableLayout;
    private TableLayout upcomingTableLayout;
    private TextView gradeTV;
    private TextView targetGradeTV;
    private final String subject = "Fifth Subject";
    private Button delBTN;
    subject subjectObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_subject);
        mDatabaseHelper = new DatabaseHelper(this);
        addAssignmentBTN = findViewById(R.id.fifthSubAddAssignmentBTN);
        addGradeBTN = findViewById(R.id.fifthSubAddGradeBTN);
        mTableLayout =findViewById(R.id.fifthSubTableLayout);
        upcomingTableLayout =findViewById(R.id.fifthSubUpcomingTableLayout);
        gradeTV = findViewById(R.id.fifthSubGrade);
        targetGradeTV = findViewById(R.id.fifthSubTG);
        subjectObj = new subject(mDatabaseHelper);
        delBTN = findViewById(R.id.fifthSubDelBTN);


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
        Cursor data = mDatabaseHelper.getFifthSubjectData();
        String gpa =subjectObj.getLetterGrade(data);
        data.close();

        return gpa;
    }

    private void calculateGrade() {

        Cursor data = mDatabaseHelper.getFifthSubjectData();
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

        Cursor data = mDatabaseHelper.getFifthSubjectData();
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
        Cursor data = mDatabaseHelper.getFifthSubjectData();
        subjectObj.populateUngradedAssignments(data,upcomingTableLayout,this);
        data.close();
    }

    private void populateGradedTable(){
        Cursor data = mDatabaseHelper.getFifthSubjectData();
        subjectObj.populateGradedTable(data, mTableLayout, this);
        data.close();
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}