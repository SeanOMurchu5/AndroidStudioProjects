package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class addGradeActivity extends AppCompatActivity {

    private DatabaseHelper mDatabaseHelper;

    private TableLayout mTableLayout;
    private Button submitBTN;
    private EditText et1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        mDatabaseHelper = new DatabaseHelper(this);
        submitBTN = findViewById(R.id.submitGradesBTN);
        mTableLayout = findViewById(R.id.addGradeTableLayout);
        String subject;
        Bundle extras = getIntent().getExtras();
        subject= extras.getString("subject");
        switch (subject){
            case "First Subject":
                displayFirstSubjectGrades();
                break;
            case "Second Subject":
                displaySecondSubjectGrades();
                break;
            case "Third Subject":
                displayThirdSubjectGrades();
                break;
            case "Fourth Subject":
                displayFourthSubjectGrades();
                break;
            case "Fifth Subject":
                displayFifthSubjectGrades();
                break;
            case "Sixth Subject":
                displaySixthSubjectGrades();
                break;

        }


    }


    private void toastMessage(String s) {
    }

    private void displaySixthSubjectGrades() {
        Cursor data = mDatabaseHelper.getSixthSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);

        tr_head.addView(name_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {




            do {
                i++;
                TableRow row = new TableRow(this);
                String name = data.getString(1);

                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                EditText et1 = new EditText(this);
                et1.setHint(R.string.enterGrade);
                et1.setGravity(Gravity.CENTER);

                submitBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean insertGrade = mDatabaseHelper.addGrade(name, "Sixth Subject", Integer.parseInt(et1.getText().toString()));
                        finish();
                    }
                });




                row.addView(tv1);
                row.addView(et1);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }

    private void displayFifthSubjectGrades() {
        Cursor data = mDatabaseHelper.getFifthSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);





        tr_head.addView(name_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {




            do {
                i++;
                TableRow row = new TableRow(this);
                String name = data.getString(1);

                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);


                EditText et1 = new EditText(this);
                et1.setHint(R.string.enterGrade);
                et1.setGravity(Gravity.CENTER);
                submitBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean insertGrade = mDatabaseHelper.addGrade(name, "Fifth Subject", Integer.parseInt(et1.getText().toString()));
                        finish();

                    }
                });

                row.addView(tv1);
                row.addView(et1);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }

    private void displayFourthSubjectGrades() {
        Cursor data = mDatabaseHelper.getFourthSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);

        tr_head.addView(name_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {




            do {
                i++;
                TableRow row = new TableRow(this);
                String name = data.getString(1);

                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                EditText et1 = new EditText(this);
                et1.setHint(R.string.enterGrade);
                et1.setGravity(Gravity.CENTER);
                submitBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean insertGrade = mDatabaseHelper.addGrade(name, "Fourth Subject", Integer.parseInt(et1.getText().toString()));
                        finish();

                    }
                });


                row.addView(tv1);

                row.addView(et1);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }

    private void displayThirdSubjectGrades() {
        Cursor data = mDatabaseHelper.getThirdSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);


        tr_head.addView(name_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {




            do {
                i++;
                TableRow row = new TableRow(this);
                String name = data.getString(1);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);


                EditText et1 = new EditText(this);
                et1.setHint(R.string.enterGrade);
                et1.setGravity(Gravity.CENTER);
                submitBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean insertGrade = mDatabaseHelper.addGrade(name, "Third Subject", Integer.parseInt(et1.getText().toString()));
                        finish();

                    }
                });


                row.addView(tv1);
                row.addView(et1);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }

    private void displaySecondSubjectGrades() {
        Cursor data = mDatabaseHelper.getSecondSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);

        tr_head.addView(name_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {




            do {
                i++;
                TableRow row = new TableRow(this);
                String name = data.getString(1);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);


                EditText et1 = new EditText(this);
                et1.setHint(R.string.enterGrade);
                et1.setGravity(Gravity.CENTER);
                submitBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean insertGrade = mDatabaseHelper.addGrade(name, "Second Subject", Integer.parseInt(et1.getText().toString()));
                        finish();

                    }
                });

                row.addView(tv1);

                row.addView(et1);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }

    private void displayFirstSubjectGrades() {
        Cursor data = mDatabaseHelper.getFirstSubjectData();
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(this);
        grade_header.setTextSize(20);
        grade_header.setText(R.string.gradeHeader);
        grade_header.setTypeface(null, Typeface.BOLD);
        grade_header.setGravity(Gravity.CENTER);


        tr_head.addView(name_header);
        tr_head.addView(grade_header);

        mTableLayout.addView(tr_head);
        int i = 0;
        if(data != null && data.moveToFirst()) {




            do {
                i++;
                TableRow row = new TableRow(this);
                String name = data.getString(1);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);


                EditText et1 = new EditText(this);
                et1.setHint(R.string.enterGrade);
                et1.setGravity(Gravity.CENTER);

                submitBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        boolean insertGrade = mDatabaseHelper.addGrade(name, "First Subject", Integer.parseInt(et1.getText().toString()));
                        finish();

                    }
                });

                row.addView(tv1);
                row.addView(et1);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }


}