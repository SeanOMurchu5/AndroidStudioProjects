package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button firstSubjectBTN;
    private Button secondSubjectBTN;
    private Button thirdSubjectBTN;
    private Button fourthSubjectBTN;
    private Button fifthSubjectBTN;
    private Button sixthSubjectBTN;
    private DatabaseHelper mDatabaseHelper;
    private TextView semGPA;
    private TextView careerGPA;
    private TextView targetGPA;
    private TextView firstGradeTV;
    private TextView secondGradeTV;
    private TextView thirdGradeTV;
    private TextView fourGradeTV;
    private TextView fifthGradeTV;
    private TextView sixthGradeTV;








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
        careerGPA = findViewById(R.id.careerGpaID);
        targetGPA = findViewById(R.id.targetGPAID);
        firstGradeTV = findViewById(R.id.firstSubGradeTV);
        secondGradeTV = findViewById(R.id.secondSubGradeTV);
        thirdGradeTV = findViewById(R.id.thirdSubGradeTV);
        fourGradeTV = findViewById(R.id.fourSubGradeTV);
        fifthGradeTV = findViewById(R.id.fifthSubGradeTV);
        sixthGradeTV = findViewById(R.id.sixthSubGradeTV);






        calculateAverageGrade();
        calculateTotalGPA();
        calculateTargetGPA();
        
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
           gpa="A-";
       }else if(grade>=80){
           gpa="B+";
       }else if(grade>=75){
           gpa="B";
       }else if(grade>=70){
           gpa="B-";
       }else if(grade>=65){
           gpa="C+";
       }else if(grade>=60){
           gpa="C";
       }else if(grade>=55){
           gpa="C-";
       }else if(grade>=50){
           gpa="D+";
       }else if(grade>=45){
           gpa="D";
       }else if(grade>=40){
           gpa="D-";
       }else{
           gpa="E";
       }

        semGPA.setText(gpa);
    }

    public void calculateTotalGPA() {
         Cursor data = mDatabaseHelper.getFirstSubjectData();
         String firstSubGrade = calculateGrade(data);
         firstGradeTV.setText(firstSubGrade);
         if(firstSubGrade.equalsIgnoreCase("F")){
             firstGradeTV.setVisibility(View.INVISIBLE);
         }
         data = mDatabaseHelper.getSecondSubjectData();
         String secondSubGrade = calculateGrade(data);
        secondGradeTV.setText(secondSubGrade);
        if(secondSubGrade.equalsIgnoreCase("F")){
            secondGradeTV.setVisibility(View.INVISIBLE);
        }
         data = mDatabaseHelper.getThirdSubjectData();
         String thirdSubGrade = calculateGrade(data);
         thirdGradeTV.setText(thirdSubGrade);
        if(thirdSubGrade.equalsIgnoreCase("F")){
            thirdGradeTV.setVisibility(View.INVISIBLE);
        }
         data = mDatabaseHelper.getFourthSubjectData();
         String fourthSubGrade = calculateGrade(data);
         fourGradeTV.setText(fourthSubGrade);
        if(fourthSubGrade.equalsIgnoreCase("F")){
            fourGradeTV.setVisibility(View.INVISIBLE);
        }
         data = mDatabaseHelper.getFifthSubjectData();
         String fifthSubGrade = calculateGrade(data);
         fifthGradeTV.setText(fifthSubGrade);
        if(fifthSubGrade.equalsIgnoreCase("F")){
            fifthGradeTV.setVisibility(View.INVISIBLE);
        }
         data = mDatabaseHelper.getSixthSubjectData();
         String sixthSubGrade = calculateGrade(data);
         sixthGradeTV.setText(sixthSubGrade);
        if(sixthSubGrade.equalsIgnoreCase("F")){
            sixthGradeTV.setVisibility(View.INVISIBLE);
        }

         ArrayList<String> grades = new ArrayList<>();
         grades.add(firstSubGrade);
         grades.add(secondSubGrade);
         grades.add(thirdSubGrade);
         grades.add(fourthSubGrade);
         grades.add(fifthSubGrade);
         grades.add(sixthSubGrade);
         double totalGPA=0;
         double val=0;
         double num=6;
         for(int i = 0; i <= 5; i++){
             switch(grades.get(i)){
                 case "A+":
                     val = 4.2;
                     break;
                 case "A":
                     val = 4;
                     break;
                 case "A-":
                     val = 3.8;
                     break;
                 case "B+":
                     val = 3.6;
                     break;

                 case "B":
                     val = 3.4;
                     break;

                 case "B-":
                     val = 3.2;
                     break;

                 case "C+":
                     val = 3;
                     break;

                 case "C":
                     val = 2.8;
                     break;

                 case "C-":
                     val = 2.6;
                     break;

                 case "D+":
                     val = 2.4;
                     break;

                 case "D":
                     val = 2.2;
                     break;

                 case "D-":
                     val = 2;
                     break;

                 case "E":
                     val = 0;
                     break;
                 case "F":
                     val = 0;
                     num--;
                     break;


             }
             totalGPA += val;
         }

         double GPA = totalGPA/num;
        if (GPA < 0){
            GPA = 0;
        }
         String GPAString = String.valueOf(GPA);
         GPAString.format("%.2f",GPA);
         careerGPA.setText(String.format("%.2f",GPA));


    }

    public void calculateTargetGPA(){
        Cursor data = mDatabaseHelper.getFirstSubjectData();
        String firstSubGrade = calculateTargetGrade(data);
        data = mDatabaseHelper.getSecondSubjectData();
        String secondSubGrade = calculateTargetGrade(data);
        data = mDatabaseHelper.getThirdSubjectData();
        String thirdSubGrade = calculateTargetGrade(data);
        data = mDatabaseHelper.getFourthSubjectData();
        String fourthSubGrade = calculateTargetGrade(data);
        data = mDatabaseHelper.getFifthSubjectData();
        String fifthSubGrade = calculateTargetGrade(data);
        data = mDatabaseHelper.getSixthSubjectData();
        String sixthSubGrade = calculateTargetGrade(data);

        ArrayList<String> grades = new ArrayList<>();
        grades.add(firstSubGrade);
        grades.add(secondSubGrade);
        grades.add(thirdSubGrade);
        grades.add(fourthSubGrade);
        grades.add(fifthSubGrade);
        grades.add(sixthSubGrade);
        double totalGPA=0;
        double val=0;
        double num=6;
        for(int i = 0; i <= 5; i++){
            switch(grades.get(i)){
                case "A+":
                    val = 4.2;
                    break;
                case "A":
                    val = 4;
                    break;
                case "A-":
                    val = 3.8;
                    break;
                case "B+":
                    val = 3.6;
                    break;

                case "B":
                    val = 3.4;
                    break;

                case "B-":
                    val = 3.2;
                    break;

                case "C+":
                    val = 3;
                    break;

                case "C":
                    val = 2.8;
                    break;

                case "C-":
                    val = 2.6;
                    break;

                case "D+":
                    val = 2.4;
                    break;

                case "D":
                    val = 2.2;
                    break;

                case "D-":
                    val = 2;
                    break;

                case "E":
                    val = 0;
                    break;
                case "F":
                    val = 0;
                    num--;
                    break;


            }
            totalGPA += val;
        }

        double GPA = totalGPA/num;
        if (GPA < 0){
            GPA = 0;
        }
        String GPAString = String.valueOf(GPA);
        GPAString.format("%.2f",GPA);
        targetGPA.setText(String.format("%.2f",GPA));

    }

    public String calculateGrade(Cursor data){
        int grade=0;
        int num=0;
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
            gpa="A-";
        }else if(grade>=80){
            gpa="B+";
        }else if(grade>=75){
            gpa="B";
        }else if(grade>=70){
            gpa="B-";
        }else if(grade>=65){
            gpa="C+";
        }else if(grade>=60){
            gpa="C";
        }else if(grade>=55){
            gpa="C-";
        }else if(grade>=50){
            gpa="D+";
        }else if(grade>=45){
            gpa="D";
        }else if(grade>=40){
            gpa="D-";
        }else if(grade>1){
            gpa="E";
        }else{
            gpa="F";
        }

       return gpa;
    }

    public String calculateTargetGrade(Cursor data){
        int grade=0;
        int num=0;
        if(data != null && data.moveToFirst()) {
            do {
                if ((!data.getString(3).equalsIgnoreCase(""))&&(!data.getString(3).equalsIgnoreCase("0"))) {

                    String gradeString = data.getString(3);
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
            gpa="A-";
        }else if(grade>=80){
            gpa="B+";
        }else if(grade>=75){
            gpa="B";
        }else if(grade>=70){
            gpa="B-";
        }else if(grade>=65){
            gpa="C+";
        }else if(grade>=60){
            gpa="C";
        }else if(grade>=55){
            gpa="C-";
        }else if(grade>=50){
            gpa="D+";
        }else if(grade>=45){
            gpa="D";
        }else if(grade>=40){
            gpa="D-";
        }else if(grade>1){
            gpa="E";
        }else{
            gpa="F";
        }

        return gpa;
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