package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends LifecycleActivity {

    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }


    @Override
    protected void onResume() {
       TextView textView = findViewById(R.id.counterView);
       textView.setText(String.valueOf(counter));
       super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        counter++;
        //outState.puInt("key1", counter);
        makeToast("onSaveInstanceState");
        makeNotification("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        makeToast("onRestoreInstanceState");
        makeNotification("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }




}