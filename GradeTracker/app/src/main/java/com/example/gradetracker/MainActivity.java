package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     Button firstSubjectBTN;
     Button secondSubjectBTN;
    Button thirdSubjectBTN;
    Button fourthSubjectBTN;
    Button fifthSubjectBTN;
    Button sixthSubjectBTN;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstSubjectBTN = (Button)findViewById(R.id.firstSubjectBTN);
        secondSubjectBTN = (Button)findViewById(R.id.secondSubjectBTN);
        thirdSubjectBTN = (Button)findViewById(R.id.thirdSubjectBTN);
        fourthSubjectBTN = (Button)findViewById(R.id.fourthSubjectBTN);
        fifthSubjectBTN = (Button)findViewById(R.id.fifthSubjectBTN);
        sixthSubjectBTN = (Button)findViewById(R.id.sixthSubjectBTN);
        
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