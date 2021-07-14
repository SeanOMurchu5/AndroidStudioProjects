package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class firstGradeActivity extends AppCompatActivity {
    private static final String TAG = "firstGradeActivity";
    private DatabaseHelper mDatabaseHelper;
    private Button addAssignmentBTN;
    private Button addGradeBTN;
    private Button delBTN;
    private TableLayout mTableLayout;
    private TableLayout upcomingTableLayout;
    private TextView gradeTV;
    private TextView targetGradeTV;
    private String letterGrade;
    private final String subject = "First Subject";
    subject subjectObj;
    SharedPreferences subjectPrefs;
    private TextView subHeader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_grade);
         subjectObj = new subject(mDatabaseHelper);
        subjectPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mDatabaseHelper = new DatabaseHelper(this);
        addAssignmentBTN = findViewById(R.id.firstSubAddAssignmentBTN);
        delBTN = findViewById(R.id.firstSubDelBTN);
        addGradeBTN = findViewById(R.id.firstSubAddGradeBTN);
        mTableLayout =findViewById(R.id.firstSubTableLayout);
        upcomingTableLayout =findViewById(R.id.firstSubUpcomingTableLayout);
        gradeTV = findViewById(R.id.firstSubGrade);
        targetGradeTV = findViewById(R.id.firstSubTG);
        letterGrade = getLetterGrade();
        subHeader = findViewById(R.id.firstSubHeader);
        subHeader.setText(subjectPrefs.getString("FirstSubName",getResources().getString(R.string.firstSubject)));


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
        Cursor data = mDatabaseHelper.getFirstSubjectData();
        String gpa =subjectObj.getLetterGrade(data);
        data.close();

        return gpa;
    }

    private void calculateGrade() {

        Cursor data = mDatabaseHelper.getFirstSubjectData();
        String gradeAverage =  subjectObj.getCalculatedGrade(data);
        data.close();
        gradeTV.setText(gradeAverage+"%");
    }

    private void calculateTargetGrade() {

        Cursor data = mDatabaseHelper.getFirstSubjectData();
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

    public void deleteAssignment(){
        Intent intent = new Intent(this, deleteAssignment.class);
        intent.putExtra("subject",subject);
        startActivity(intent);
    }

    private void populateUngradedAssignments(){
        Cursor data = mDatabaseHelper.getFirstSubjectData();
        subjectObj.populateUngradedAssignments(data,upcomingTableLayout,this);
        data.close();
    }

    private void populateGradedTable(){
        Cursor data = mDatabaseHelper.getFirstSubjectData();
        subjectObj.populateGradedTable(data, mTableLayout, this);
        data.close();
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}