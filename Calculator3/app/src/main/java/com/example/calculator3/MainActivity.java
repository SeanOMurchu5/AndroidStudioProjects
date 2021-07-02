package com.example.calculator3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();

         int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
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
     display.setText("");
    }

    public void rightParenthesesBTNPush(View view){
        updateText(getResources().getString(R.string.rightParentheses));
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
    public void leftParenthesesBTNPush(View view){
        updateText(getResources().getString(R.string.leftParentheses));
    }
    public void pointBTNPush(View view){
        updateText(getResources().getString(R.string.point));
    }

    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void equalsBTNPush(View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll(getResources().getString(R.string.divide), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }


}