package com.example.gradetracker;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class subject {
    private DatabaseHelper DatabaseHelper;
    private Cursor data1;
    subject(DatabaseHelper mDatabaseHelper){
        DatabaseHelper = mDatabaseHelper;

    }

    public String getLetterGrade(Cursor data) {

        data1 = data;
        double grade=0;
        double num=0;

        if(data != null && data.moveToFirst()) {
            do {
                if (data.getDouble(5)!=0) {
                    double gradeValue = data.getDouble(5);
                    if(gradeValue>0){
                        num++;
                        grade += gradeValue;
                    }
                }

            } while (data.moveToNext());
        }
        data.close();
        if(num==0){
            num=1;
        }

        grade = grade/num;
        String gpa;

        if(grade>=95){
            gpa="A+";
        }else if(grade>=90){
            gpa="A";
        }else if(grade>=85){
            gpa="-A";
        }else if(grade>=80){
            gpa="B+";
        }else if(grade>=75){
            gpa="B";
        }else if(grade>=70){
            gpa="-B";
        }else if(grade>=65){
            gpa="C+";
        }else if(grade>=60){
            gpa="C";
        }else if(grade>=55){
            gpa="-C";
        }else if(grade>=50){
            gpa="D+";
        }else if(grade>=45){
            gpa="D";
        }else if(grade>=40){
            gpa="-D";
        }else{
            gpa="E";
        }

        return gpa;
    }

    public String getCalculatedGrade(Cursor data) {

        double grade=0;
        double num=0;
        data1 = data;

        if(data != null && data.moveToFirst()) {
            do {
                if (data.getDouble(5)!=0) {
                    num++;
                    double newGrade = data.getDouble(5);
                    grade += newGrade;
                }
            } while (data.moveToNext());
        }
        data.close();
        if(num==0){
            num=1;
        }

        String gradeAverage = String.valueOf(grade);
        return gradeAverage;
    }

    public String getCalculateTargetGrade(Cursor data) {
        double targetGrade=0;
        double num=0;
        data1 = data;

        if(data != null && data.moveToFirst()) {
            do {
                num++;
                double targetGradeValue = data.getDouble(3);
                targetGrade += targetGradeValue;

            } while (data.moveToNext());
        }
        data.close();
        if(num==0){
            num=1;
        }

        targetGrade = targetGrade/num;
        String targetGradeAverage = String.valueOf(targetGrade);
        return targetGradeAverage;
    }

    public void populateUngradedAssignments(Cursor data, TableLayout upcomingTableLayout, Activity activity){
        upcomingTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(activity);

        TextView name_header = new TextView(activity);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView weight_header = new TextView(activity);
        weight_header.setTextSize(20);
        weight_header.setText(R.string.gradeWeight);
        weight_header.setTypeface(null, Typeface.BOLD);
        weight_header.setGravity(Gravity.CENTER);


        TextView targetGrade_header = new TextView(activity);
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
                if(data.getDouble(5)==0) {
                    i++;
                    TableRow row = new TableRow(activity);
                    String name = data.getString(1);
                    double weight = data.getDouble(2);
                    String targetGrade = data.getString(3);


                    TextView tv1 = new TextView(activity);
                    tv1.setTextSize(20);
                    tv1.setText(name);
                    tv1.setGravity(Gravity.CENTER);

                    TextView tv2 = new TextView(activity);
                    tv2.setText(String.valueOf(weight));
                    tv2.setTextSize(20);
                    tv2.setGravity(Gravity.CENTER);

                    TextView tv3 = new TextView(activity);
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

    }

    public void populateGradedTable(Cursor data,TableLayout mTableLayout, Activity activity){
        mTableLayout.setStretchAllColumns(true);

        TableRow tr_head = new TableRow(activity);

        TextView name_header = new TextView(activity);
        name_header.setTextSize(20);
        name_header.setText(R.string.topic);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView weight_header = new TextView(activity);
        weight_header.setTextSize(20);
        weight_header.setText(R.string.gradeWeight);
        weight_header.setTypeface(null, Typeface.BOLD);
        weight_header.setGravity(Gravity.CENTER);

        TextView grade_header = new TextView(activity);
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
                if(data.getDouble(5)!=0) {
                    i++;
                    TableRow row = new TableRow(activity);
                    String name = data.getString(1);
                    double weight = data.getDouble(2);
                    String grade = data.getString(5);


                    TextView tv1 = new TextView(activity);
                    tv1.setTextSize(20);
                    tv1.setText(name);
                    tv1.setGravity(Gravity.CENTER);

                    TextView tv2 = new TextView(activity);
                    tv2.setText(String.valueOf(weight));
                    tv2.setTextSize(20);
                    tv2.setGravity(Gravity.CENTER);


                    TextView tv4 = new TextView(activity);
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
    }

}
