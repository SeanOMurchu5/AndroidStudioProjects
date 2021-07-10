package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button firstSubjectBTN;
    private Button secondSubjectBTN;
    private Button thirdSubjectBTN;
    private Button fourthSubjectBTN;
    private Button fifthSubjectBTN;
    private Button sixthSubjectBTN;
    private DatabaseHelper mDatabaseHelper;
    private TextView semGPA;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseHelper = new DatabaseHelper(this);
        firstSubjectBTN = (Button)findViewById(R.id.firstSubjectBTN);
        secondSubjectBTN = (Button)findViewById(R.id.secondSubjectBTN);
        thirdSubjectBTN = (Button)findViewById(R.id.thirdSubjectBTN);
        fourthSubjectBTN = (Button)findViewById(R.id.fourthSubjectBTN);
        fifthSubjectBTN = (Button)findViewById(R.id.fifthSubjectBTN);
        sixthSubjectBTN = (Button)findViewById(R.id.sixthSubjectBTN);
        semGPA = findViewById(R.id.semesterGpaID);

        calculateAverageGrade();
        calculateTotalGPA();
        
        firstSubjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstSubjectActivity();
            }
        });
        secondSubjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondSubjectActivity();
            }
        });
        thirdSubjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThirdSubjectActivity();
            }
        });
        fourthSubjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourthSubjectActivity();
            }
        });
        fifthSubjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFifthSubjectActivity();
            }
        });
        sixthSubjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSixthSubjectActivity();
            }
        });
    }

    private void calculateAverageGrade() {
        int grade=0;
        int num=0;
        double totalGPA=0;
        Cursor data = mDatabaseHelper.getData();
        if(data != null && data.moveToFirst()) {
            do {
                if ((!data.getString(5).equalsIgnoreCase(""))&&(!data.getString(5).equalsIgnoreCase("0"))) {

                    String gradeString = data.getString(5);
                    int gradeval = Integer.parseInt(gradeString);
                    if(gradeval>0){
                        num++;
                        grade += Integer.parseInt(gradeString);

                        }
                    }

            } while (data.moveToNext());
        }
        data.close();
        if(num==0){
            num=1;
        }

        System.out.println(grade);
        System.out.println(num);

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

        semGPA.setText(gpa);
    }

    public void calculateTotalGPA() {
        firstGradeActivity fga = firstGradeActivity.getInstance();
        String firstSubGrade = fga.getLetterGrade();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    private void openSixthSubjectActivity() {
        Intent intent = new Intent(this, sixthSubjectActivity.class);
        startActivity(intent);
    }

    private void openFifthSubjectActivity() {
        Intent intent = new Intent(this, fifthSubjectActivity.class);
        startActivity(intent);
    }

    private void openFourthSubjectActivity() {
        Intent intent = new Intent(this, fourthSubjectActivity.class);
        startActivity(intent);
    }

    private void openThirdSubjectActivity() {
        Intent intent = new Intent(this, thirdSubjectActivity.class);
        startActivity(intent);
    }

    private void openSecondSubjectActivity() {
        Intent intent = new Intent(this, secondSubjectActivity.class);
        startActivity(intent);
    }

    public void openFirstSubjectActivity( ){
        Intent intent = new Intent(this, firstGradeActivity.class);
        startActivity(intent);
    }


}