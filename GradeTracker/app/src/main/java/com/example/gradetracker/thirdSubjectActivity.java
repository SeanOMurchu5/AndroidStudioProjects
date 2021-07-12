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

public class thirdSubjectActivity extends AppCompatActivity {
    private static final String TAG = "thirdGradeActivity";
    private DatabaseHelper mDatabaseHelper;
    private Button addAssignmentBTN;
    private Button addGradeBTN;
    private TableLayout mTableLayout;
    private TableLayout upcomingTableLayout;
    private TextView gradeTV;
    private TextView targetGradeTV;
    private final String subject = "Third Subject";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_subject);
        mDatabaseHelper = new DatabaseHelper(this);
        addAssignmentBTN = findViewById(R.id.thirdSubAddAssignmentBTN);
        addGradeBTN = findViewById(R.id.thirdSubAddGradeBTN);
        mTableLayout =findViewById(R.id.thirdSubTableLayout);
        upcomingTableLayout =findViewById(R.id.thirdSubUpcomingTableLayout);
        gradeTV = findViewById(R.id.thirdSubGrade);
        targetGradeTV = findViewById(R.id.thirdSubTG);

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

    private void calculateGrade() {
        int grade=0;
        int num=0;
        Cursor data = mDatabaseHelper.getThirdSubjectData();
        if(data != null && data.moveToFirst()) {
            do {
                if (!data.getString(5).equalsIgnoreCase("")) {
                    num++;
                    String gradeString = data.getString(5);
                    grade += Integer.parseInt(gradeString);
                }
            } while (data.moveToNext());
        }
        data.close();
        if(num==0){
            num=1;
        }

        grade = grade/num;
        String gradeAverage = String.valueOf(grade);
        gradeTV.setText(gradeAverage);
    }

    private void calculateTargetGrade() {
        int targetGrade=0;
        int num=0;
        Cursor data = mDatabaseHelper.getThirdSubjectData();
        if(data != null && data.moveToFirst()) {
            do {
                num++;
                String targetGradeString = data.getString(3);
                targetGrade += Integer.parseInt(targetGradeString);

            } while (data.moveToNext());
        }
        data.close();
        if(num==0){
            num=1;
        }

        targetGrade = targetGrade/num;
        String targetGradeAverage = String.valueOf(targetGrade);
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
        Cursor data = mDatabaseHelper.getThirdSubjectData();
        upcomingTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView weight_header = new TextView(this);
        weight_header.setTextSize(20);
        weight_header.setText(R.string.gradeWeight);
        weight_header.setTypeface(null, Typeface.BOLD);
        weight_header.setGravity(Gravity.CENTER);


        TextView targetGrade_header = new TextView(this);
        targetGrade_header.setTextSize(20);
        targetGrade_header.setText(R.string.targetGrade);
        targetGrade_header.setTypeface(null, Typeface.BOLD);
        targetGrade_header.setGravity(Gravity.CENTER);


        tr_head.addView(name_header);
        tr_head.addView(weight_header);
        tr_head.addView(targetGrade_header);

        upcomingTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {

            do {
                if(data.getString(5).equalsIgnoreCase("")) {
                    i++;
                    TableRow row = new TableRow(this);
                    String name = data.getString(1);
                    String weight = data.getString(2);
                    String targetGrade = data.getString(3);


                    TextView tv1 = new TextView(this);
                    tv1.setTextSize(20);
                    tv1.setText(name);
                    tv1.setGravity(Gravity.CENTER);

                    TextView tv2 = new TextView(this);
                    tv2.setText(weight);
                    tv2.setTextSize(20);
                    tv2.setGravity(Gravity.CENTER);

                    TextView tv3 = new TextView(this);
                    tv3.setText(targetGrade);
                    tv3.setTextSize(20);
                    tv3.setGravity(Gravity.CENTER);

                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(tv3);
                    upcomingTableLayout.addView(row);
                }

            } while (data.moveToNext());

        }
        data.close();
    }

    private void populateGradedTable(){
        Cursor data = mDatabaseHelper.getThirdSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView weight_header = new TextView(this);
        weight_header.setTextSize(20);
        weight_header.setText(R.string.gradeWeight);
        weight_header.setTypeface(null, Typeface.BOLD);
        weight_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);


        tr_head.addView(name_header);
        tr_head.addView(weight_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {


            do {
                if(!data.getString(5).equalsIgnoreCase("")) {
                    i++;
                    TableRow row = new TableRow(this);
                    String name = data.getString(1);
                    String weight = data.getString(2);
                    String grade = data.getString(5);


                    TextView tv1 = new TextView(this);
                    tv1.setTextSize(20);
                    tv1.setText(name);
                    tv1.setGravity(Gravity.CENTER);

                    TextView tv2 = new TextView(this);
                    tv2.setText(weight);
                    tv2.setTextSize(20);
                    tv2.setGravity(Gravity.CENTER);

                    TextView tv4 = new TextView(this);
                    tv4.setText(grade);
                    tv4.setTextSize(20);
                    tv4.setGravity(Gravity.CENTER);

                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(tv4);
                    mTableLayout.addView(row);
                }

            } while (data.moveToNext());

        }
        data.close();
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}