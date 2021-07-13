package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

public class editScreen extends AppCompatActivity {

    private Spinner spinner;
    String firstSub;
    String secondSub;
    String thirdSub;
    String fourthSub;
    String fifthSub;
    String sixthSub;
    private TableLayout mTableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTableLayout = findViewById(R.id.editTableLayout);
        firstSub = getResources().getString(R.string.firstSubject);
        secondSub = getResources().getString(R.string.secondSubject);
        thirdSub = getResources().getString(R.string.thirdSubject);
        fourthSub = getResources().getString(R.string.fourthSubject);
        fifthSub = getResources().getString(R.string.fifthSubject);
        sixthSub = getResources().getString(R.string.sixthSubject);

        setContentView(R.layout.activity_edit_screen);
        editSubjects();
    }

    private void editSubjects() {
        mTableLayout.setStretchAllColumns(true);
        TableRow tr_head = new TableRow(this);

        TextView name_header = new TextView(this);
        name_header.setTextSize(20);
        name_header.setText(R.string.subject);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView visibility_header = new TextView(this);
        visibility_header.setTextSize(20);
        visibility_header.setText(R.string.visible);
        visibility_header.setTypeface(null, Typeface.BOLD);
        visibility_header.setGravity(Gravity.CENTER);

        tr_head.addView(name_header);
        tr_head.addView(visibility_header);

        mTableLayout.addView(tr_head);

                TableRow row = new TableRow(this);
                String name = getResources().getString(R.string.firstSubject);
                TextView tv1 = new TextView(this);
                tv1.setTextSize(20);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                ToggleButton tb1 = new ToggleButton(this);

                row.addView(tv1);
                row.addView(tb1);

        mTableLayout.addView(row);

        TableRow row2 = new TableRow(this);
        String name2 = getResources().getString(R.string.secondSubject);
        TextView tv2 = new TextView(this);
        tv2.setTextSize(20);
        tv2.setText(name);
        tv2.setGravity(Gravity.CENTER);

        ToggleButton tb2 = new ToggleButton(this);

        row2.addView(tv2);
        row2.addView(tb2);

        mTableLayout.addView(row2);

        TableRow row3 = new TableRow(this);
        String name3= getResources().getString(R.string.thirdSubject);
        TextView tv3 = new TextView(this);
        tv3.setTextSize(20);
        tv3.setText(name);
        tv3.setGravity(Gravity.CENTER);

        ToggleButton tb3 = new ToggleButton(this);

        row3.addView(tv3);
        row3.addView(tb3);

        mTableLayout.addView(row3);

        TableRow row4 = new TableRow(this);
        String name4 = getResources().getString(R.string.fourthSubject);
        TextView tv4= new TextView(this);
        tv4.setTextSize(20);
        tv4.setText(name);
        tv4.setGravity(Gravity.CENTER);

        ToggleButton tb4 = new ToggleButton(this);

        row4.addView(tv4);
        row4.addView(tb4);

        mTableLayout.addView(row4);

        TableRow row5 = new TableRow(this);
        String name5= getResources().getString(R.string.fifthSubject);
        TextView tv5 = new TextView(this);
        tv5.setTextSize(20);
        tv5.setText(name);
        tv5.setGravity(Gravity.CENTER);

        ToggleButton tb5 = new ToggleButton(this);

        row5.addView(tv5);
        row5.addView(tb5);

        mTableLayout.addView(row5);

        TableRow row6 = new TableRow(this);
        String name6= getResources().getString(R.string.sixthSubject);
        TextView tv6 = new TextView(this);
        tv6.setTextSize(20);
        tv6.setText(name);
        tv6.setGravity(Gravity.CENTER);

        ToggleButton tb6 = new ToggleButton(this);

        row6.addView(tv6);
        row6.addView(tb6);

        mTableLayout.addView(row6);




    }




}