package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {
    private static final String COUNTER_KEY = "stopCounter";
    private static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        int StopCounter = prefs.getInt(COUNTER_KEY, 0);
        StopCounter++;

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(COUNTER_KEY, StopCounter);
        editor.apply();

        showStopNotification(StopCounter);
    }

    private void showStopNotification(int stopCounter) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                .setContentTitle("Activity Stopped")
                .setContentText("The activities have been stopped " + stopCounter + " times.")
                .setSmallIcon(R.drawable.ic_stat_onesignal_default); // Set your notification icon here

        notificationManager.notify(1, builder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}