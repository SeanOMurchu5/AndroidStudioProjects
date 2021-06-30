package com.example.milestones;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.milestones.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private TextView mTextViewCountDown;
    int counter;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning = false;
    private static final long START_TIME_IN_MILLIS = 600000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }

            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetTimer();

            }
        });

        updateCountDownText();

    }

    private void startTimer(){
       mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000){
           @Override
           public void onTick(long millisUntilFinished) {
             mTimeLeftInMillis = millisUntilFinished;
             updateCountDownText();
           }

           @Override
           public void onFinish() {
               mTimerRunning = false;
               mButtonStartPause.setText("Start");
               mButtonStartPause.setVisibility(View.INVISIBLE);
           }
       }.start();

       mTimerRunning = true;
       mButtonStartPause.setText("Pause");
       mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer(){
       mCountDownTimer.cancel();
       mTimerRunning = false;
       mButtonStartPause.setText("Start");
       mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer(){
      mTimeLeftInMillis = START_TIME_IN_MILLIS;
      updateCountDownText();
      mButtonReset.setVisibility(View.INVISIBLE);
      mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int) mTimeLeftInMillis/1000 / 60;
        int seconds = (int) mTimeLeftInMillis/1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}