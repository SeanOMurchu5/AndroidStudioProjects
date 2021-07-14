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
        mTableLayout.setShrinkAllColumns(true);
        TableRow tr_head = new TableRow(this);
        SharedPreferences.Editor editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();

        TextView name_header = new TextView(this);
        name_header.setTextSize(15);
        name_header.setText(R.string.subject);
        name_header.setTypeface(null, Typeface.BOLD);
        name_header.setGravity(Gravity.CENTER);

        TextView visibility_header = new TextView(this);
        visibility_header.setTextSize(15);
        visibility_header.setText(R.string.visible);
        visibility_header.setTypeface(null, Typeface.BOLD);
        visibility_header.setGravity(Gravity.CENTER);

        TextView change_Name_Header = new TextView(this);
        change_Name_Header.setTextSize(15);
        change_Name_Header.setText(R.string.subject);
        change_Name_Header.setTypeface(null, Typeface.BOLD);
        change_Name_Header.setGravity(Gravity.CENTER);

        TextView buttonHeaders = new TextView(this);
        buttonHeaders.setTextSize(15);
        buttonHeaders.setText(R.string.visible);
        buttonHeaders.setTypeface(null, Typeface.BOLD);
        buttonHeaders.setGravity(Gravity.CENTER);

        tr_head.addView(name_header);
        tr_head.addView(visibility_header);
        tr_head.addView(change_Name_Header);
        tr_head.addView(buttonHeaders);


        mTableLayout.addView(tr_head);

                TableRow row = new TableRow(this);
                String name = getResources().getString(R.string.firstSubject);
                TextView tv1 = new TextView(this);
                tv1.setTextSize(15);
                tv1.setText(name);
                tv1.setGravity(Gravity.CENTER);

                ToggleButton tb1 = new ToggleButton(this);
                tb1.setChecked(sharedPrefs.getBoolean("tb1",true));
                tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            unhideSubject("First Subject");
                            editor.putBoolean("tb1", true);
                            editor.apply();
                        }else{
                            hideSubject("First Subject");
                            editor.putBoolean("tb1", false);
                            editor.apply();
                            

                        }
                    }
                });
                EditText newFirstSubName = new EditText(this);
        newFirstSubName.setHint(R.string.enterName);
        newFirstSubName.setGravity(Gravity.CENTER);

        Button changeFirstNameBTN = new Button(this);
        changeFirstNameBTN.setText(getResources().getString(R.string.changeName));
        changeFirstNameBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor nameEditor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                nameEditor.putString("FirstSubName", newFirstSubName.getText().toString());
                nameEditor.apply();

            }
        });

        row.addView(tv1);
        row.addView(tb1);
        row.addView(newFirstSubName);
        row.addView(changeFirstNameBTN);

        mTableLayout.addView(row);

        TableRow row2 = new TableRow(this);
        String name2 = getResources().getString(R.string.secondSubject);
        TextView tv2 = new TextView(this);
        tv2.setTextSize(15);
        tv2.setText(name2);
        tv2.setGravity(Gravity.CENTER);

        ToggleButton tb2 = new ToggleButton(this);
        tb2.setChecked(sharedPrefs.getBoolean("tb2",true));
        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Second Subject");
                    editor.putBoolean("tb2", true);
                    editor.apply();
                }else{
                    hideSubject("Second Subject");
                    editor.putBoolean("tb2", false);
                    editor.apply();


                }
            }
        });

        EditText newSecondSubName = new EditText(this);
        newSecondSubName.setHint(R.string.enterName);
        newSecondSubName.setGravity(Gravity.CENTER);

        Button changeSecondNameBTN = new Button(this);
        changeSecondNameBTN.setText(getResources().getString(R.string.changeName));
        changeSecondNameBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor nameEditor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                nameEditor.putString("SecondSubName", newSecondSubName.getText().toString());
                nameEditor.apply();

            }
        });

        row2.addView(tv2);
        row2.addView(tb2);
        row2.addView(newSecondSubName);
        row2.addView(changeSecondNameBTN);

        mTableLayout.addView(row2);

        TableRow row3 = new TableRow(this);
        String name3= getResources().getString(R.string.thirdSubject);
        TextView tv3 = new TextView(this);


        tv3.setTextSize(15);
        tv3.setText(name3);
        tv3.setGravity(Gravity.CENTER);

        ToggleButton tb3 = new ToggleButton(this);
        tb3.setChecked(sharedPrefs.getBoolean("tb3",true));
        tb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Third Subject");
                    editor.putBoolean("tb3", true);
                    editor.apply();
                }else{
                    hideSubject("Third Subject");
                    editor.putBoolean("tb3", false);
                    editor.apply();


                }
            }
        });

        EditText newThirdSubName = new EditText(this);
        newThirdSubName.setHint(R.string.enterName);
        newThirdSubName.setGravity(Gravity.CENTER);

        Button changeThirdNameBTN = new Button(this);
        changeThirdNameBTN.setText(getResources().getString(R.string.changeName));
        changeThirdNameBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor nameEditor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                nameEditor.putString("ThirdSubName", newThirdSubName.getText().toString());
                nameEditor.apply();

            }
        });

        row3.addView(tv3);
        row3.addView(tb3);
        row3.addView(newThirdSubName);
        row3.addView(changeThirdNameBTN);

        mTableLayout.addView(row3);

        TableRow row4 = new TableRow(this);
        String name4 = getResources().getString(R.string.fourthSubject);
        TextView tv4= new TextView(this);
        tv4.setTextSize(15);
        tv4.setText(name4);
        tv4.setGravity(Gravity.CENTER);

        ToggleButton tb4 = new ToggleButton(this);
        tb4.setChecked(sharedPrefs.getBoolean("tb4",true));
        tb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Fourth Subject");
                    editor.putBoolean("tb4", true);
                    editor.apply();
                }else{
                    hideSubject("Fourth Subject");
                    editor.putBoolean("tb4", false);
                    editor.apply();


                }
            }
        });

        EditText newFourthSubName = new EditText(this);
        newFourthSubName.setHint(R.string.enterName);
        newFourthSubName.setGravity(Gravity.CENTER);

        Button changeFourthNameBTN = new Button(this);
        changeFourthNameBTN.setText(getResources().getString(R.string.changeName));
        changeFourthNameBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor nameEditor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                nameEditor.putString("FourthSubName", newFourthSubName.getText().toString());
                nameEditor.apply();

            }
        });


        row4.addView(tv4);
        row4.addView(tb4);
        row4.addView(newFourthSubName);
        row4.addView(changeFourthNameBTN);

        mTableLayout.addView(row4);

        TableRow row5 = new TableRow(this);
        String name5= getResources().getString(R.string.fifthSubject);
        TextView tv5 = new TextView(this);
        tv5.setTextSize(15);
        tv5.setText(name5);
        tv5.setGravity(Gravity.CENTER);

        ToggleButton tb5 = new ToggleButton(this);
        tb5.setChecked(sharedPrefs.getBoolean("tb5",true));
        tb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    unhideSubject("Fifth Subject");
                    editor.putBoolean("tb5", true);
                    editor.apply();
                }else{
                    hideSubject("Fifth Subject");
                    editor.putBoolean("tb5", false);
                    editor.apply();


                }
            }
        });

        EditText newFifthSubName = new EditText(this);
        newFifthSubName.setHint(R.string.enterName);
        newFifthSubName.setGravity(Gravity.CENTER);

        Button changeFifthNameBTN = new Button(this);
        changeFifthNameBTN.setText(getResources().getString(R.string.changeName));
        changeFifthNameBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor nameEditor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                nameEditor.putString("FifthSubName", newFifthSubName.getText().toString());
                nameEditor.apply();

            }
        });


        row5.addView(tv5);
        row5.addView(tb5);
        row5.addView(newFifthSubName);
        row5.addView(changeFifthNameBTN);

        mTableLayout.addView(row5);

        TableRow row6 = new TableRow(this);
        String name6= getResources().getString(R.string.sixthSubject);
        TextView tv6 = new TextView(this);
        tv6.setTextSize(15);
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
        newSixthSubName.setHint(R.string.enterName);
        newSixthSubName.setGravity(Gravity.CENTER);

        Button changeSixthNameBTN = new Button(this);
        changeSixthNameBTN.setText(getResources().getString(R.string.changeName));
        changeSixthNameBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor nameEditor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
                nameEditor.putString("SixthSubName", newSixthSubName.getText().toString());
                nameEditor.apply();

            }
        });


        row6.addView(tv6);
        row6.addView(tb6);
        row6.addView(newSixthSubName);
        row6.addView(changeSixthNameBTN);

        mTableLayout.addView(row6);


    }




}