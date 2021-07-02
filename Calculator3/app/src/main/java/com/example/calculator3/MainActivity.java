package com.example.calculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
    }
    private void updateText(String strToAdd){
        display.setText(strToAdd);
    }
    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.one));
    }
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.two));
    }
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.three));
    }
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.four));
    }
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.five));
    }
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.seven));
    }
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eight));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nine));
    }
    public void clearBTNPush(View view){
        updateText("");
    }

    public void exponentBTNPush(View view){
        updateText(getResources().getString(R.string.exponent));
    }
    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divide));
    }
    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiply));
    }
    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtract));
    }
    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.add));
    }
    public void parenthesesBTNPush(View view){
        updateText(getResources().getString(R.string.parentheses));
    }
    public void pointBTNPush(View view){
        updateText(getResources().getString(R.string.point));
    }


}