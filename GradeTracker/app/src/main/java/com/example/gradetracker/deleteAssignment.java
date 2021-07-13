package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class deleteAssignment extends AppCompatActivity {

    private DatabaseHelper mDatabaseHelper;
    private TableLayout mTableLayout;
    private Button delAssignmentBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_assignment);
         mDatabaseHelper = new DatabaseHelper(this);
        Bundle extras = getIntent().getExtras();
        mTableLayout = findViewById(R.id.delAssignmentTableLayout);
        delAssignmentBTN = findViewById(R.id.delAssignmentBTN);
        String subject;
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
                int id = data.getInt(0);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                CheckBox cb = new CheckBox(this);
                tv1.setGravity(Gravity.CENTER);

                delAssignmentBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cb.isChecked()) {
                            boolean delAssignment = mDatabaseHelper.delete(id);
                            finish();
                        }

                    }
                });

                row.addView(tv1);
                row.addView(cb);
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
                int id = data.getInt(0);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                CheckBox cb = new CheckBox(this);
                tv1.setGravity(Gravity.CENTER);

                delAssignmentBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cb.isChecked()) {
                            boolean delAssignment = mDatabaseHelper.delete(id);
                            finish();
                        }

                    }
                });

                row.addView(tv1);
                row.addView(cb);
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
                int id = data.getInt(0);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                CheckBox cb = new CheckBox(this);
                tv1.setGravity(Gravity.CENTER);

                delAssignmentBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cb.isChecked()) {
                            boolean delAssignment = mDatabaseHelper.delete(id);
                            finish();
                        }

                    }
                });

                row.addView(tv1);
                row.addView(cb);
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
                int id = data.getInt(0);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                CheckBox cb = new CheckBox(this);
                tv1.setGravity(Gravity.CENTER);

                delAssignmentBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cb.isChecked()) {
                            boolean delAssignment = mDatabaseHelper.delete(id);
                            finish();
                        }

                    }
                });

                row.addView(tv1);
                row.addView(cb);
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
                int id = data.getInt(0);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                CheckBox cb = new CheckBox(this);
                tv1.setGravity(Gravity.CENTER);

                delAssignmentBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cb.isChecked()) {
                            boolean delAssignment = mDatabaseHelper.delete(id);
                            finish();
                        }

                    }
                });

                row.addView(tv1);
                row.addView(cb);
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
                int id = data.getInt(0);


                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                CheckBox cb = new CheckBox(this);
                tv1.setGravity(Gravity.CENTER);

                delAssignmentBTN.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cb.isChecked()) {
                            boolean delAssignment = mDatabaseHelper.delete(id);
                            finish();
                        }

                    }
                });

                row.addView(tv1);
                row.addView(cb);
                mTableLayout.addView(row);
            } while (data.moveToNext());

        }
        data.close();
    }
}