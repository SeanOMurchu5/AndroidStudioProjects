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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
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
    SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);

        mTableLayout = findViewById(R.id.editTableLayout);
        firstSub = getResources().getString(R.string.firstSubject);
        secondSub = getResources().getString(R.string.secondSubject);
        thirdSub = getResources().getString(R.string.thirdSubject);
        fourthSub = getResources().getString(R.string.fourthSubject);
        fifthSub = getResources().getString(R.string.fifthSubject);
        sixthSub = getResources().getString(R.string.sixthSubject);

         sharedPrefs = this.getSharedPreferences("prefs", MODE_PRIVATE);


        editSubjects();

    }

    public void hideSubject(String subject){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(subject,false);
        setResult(RESULT_OK, intent);


    }

    public void unhideSubject(String subject){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(subject,true);
        setResult(RESULT_OK, intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
                tb1.setChecked(sharedPrefs.getBoolean("tb1",true));
                tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            unhideSubject("First Subject");
                            SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                            editor.putBoolean("tb1", true);
                            editor.apply();
                        }else{
                            hideSubject("First Subject");
                            SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                            editor.putBoolean("tb1", false);
                            editor.apply();
                            

                        }
                    }
                });
                EditText newFirstSubName = new EditText(this);
        newFirstSubName.setHint(R.string.enterName);
        newFirstSubName.setGravity(Gravity.CENTER);

        row.addView(tv1);
        row.addView(tb1);
        row.addView(newFirstSubName);

        mTableLayout.addView(row);

        TableRow row2 = new TableRow(this);
        String name2 = getResources().getString(R.string.secondSubject);
        TextView tv2 = new TextView(this);
        tv2.setTextSize(20);
        tv2.setText(name2);
        tv2.setGravity(Gravity.CENTER);

        ToggleButton tb2 = new ToggleButton(this);
        tb2.setChecked(sharedPrefs.getBoolean("tb2",true));
        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Second Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb2", true);
                    editor.apply();
                }else{
                    hideSubject("Second Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb2", false);
                    editor.apply();


                }
            }
        });

        EditText newSecondSubName = new EditText(this);
        newSecondSubName.setHint(R.string.enterName);
        newSecondSubName.setGravity(Gravity.CENTER);

        row2.addView(tv2);
        row2.addView(tb2);
        row2.addView(newSecondSubName);

        mTableLayout.addView(row2);

        TableRow row3 = new TableRow(this);
        String name3= getResources().getString(R.string.thirdSubject);
        TextView tv3 = new TextView(this);
        tv3.setTextSize(20);
        tv3.setText(name3);
        tv3.setGravity(Gravity.CENTER);

        ToggleButton tb3 = new ToggleButton(this);
        tb3.setChecked(sharedPrefs.getBoolean("tb3",true));
        tb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Third Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb3", true);
                    editor.apply();
                }else{
                    hideSubject("Third Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb3", false);
                    editor.apply();


                }
            }
        });

        EditText newThirdSubName = new EditText(this);
        newThirdSubName.setHint(R.string.enterName);
        newThirdSubName.setGravity(Gravity.CENTER);

        row3.addView(tv3);
        row3.addView(tb3);
        row3.addView(newThirdSubName);

        mTableLayout.addView(row3);

        TableRow row4 = new TableRow(this);
        String name4 = getResources().getString(R.string.fourthSubject);
        TextView tv4= new TextView(this);
        tv4.setTextSize(20);
        tv4.setText(name4);
        tv4.setGravity(Gravity.CENTER);

        ToggleButton tb4 = new ToggleButton(this);
        tb4.setChecked(sharedPrefs.getBoolean("tb4",true));
        tb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Fourth Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb4", true);
                    editor.apply();
                }else{
                    hideSubject("Fourth Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb4", false);
                    editor.apply();


                }
            }
        });

        EditText newFourthSubName = new EditText(this);
        newFourthSubName.setHint(R.string.enterName);
        newFourthSubName.setGravity(Gravity.CENTER);


        row4.addView(tv4);
        row4.addView(tb4);
        row4.addView(newFourthSubName);

        mTableLayout.addView(row4);

        TableRow row5 = new TableRow(this);
        String name5= getResources().getString(R.string.fifthSubject);
        TextView tv5 = new TextView(this);
        tv5.setTextSize(20);
        tv5.setText(name5);
        tv5.setGravity(Gravity.CENTER);

        ToggleButton tb5 = new ToggleButton(this);
        tb5.setChecked(sharedPrefs.getBoolean("tb5",true));
        tb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Fifth Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb5", true);
                    editor.apply();
                }else{
                    hideSubject("Fifth Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb5", false);
                    editor.apply();


                }
            }
        });

        EditText newFifthSubName = new EditText(this);
        newFifthSubName.setHint(R.string.enterName);
        newFifthSubName.setGravity(Gravity.CENTER);


        row5.addView(tv5);
        row5.addView(tb5);
        row5.addView(newFifthSubName);

        mTableLayout.addView(row5);

        TableRow row6 = new TableRow(this);
        String name6= getResources().getString(R.string.sixthSubject);
        TextView tv6 = new TextView(this);
        tv6.setTextSize(20);
        tv6.setText(name6);
        tv6.setGravity(Gravity.CENTER);

        ToggleButton tb6 = new ToggleButton(this);
        tb6.setChecked(sharedPrefs.getBoolean("tb6",true));
        tb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Sixth Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb6", true);
                    editor.apply();
                }else{
                    hideSubject("Sixth Subject");
                    SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
                    editor.putBoolean("tb6", false);
                    editor.apply();


                }
            }
        });

        EditText newSixthSubName = new EditText(this);


        row6.addView(tv6);
        row6.addView(tb6);
        row6.addView(newSixthSubName);

        mTableLayout.addView(row6);


    }




}