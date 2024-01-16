package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends BaseActivity {
    EditText editTextName, editTextArg1, editTextArg2;
    TextView textViewName, textViewSum, textViewNone, textViewZero;
    Button buttonAdd, buttonClear;

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        String savedString = sharedPreferences.getString("entries list", "");

        // Split the string back into an ArrayList
        entries = new ArrayList<>(Arrays.asList(savedString.split(",")));

        if (entries.size() == 1 && entries.get(0).isEmpty()) {
            entries.clear(); // Clear the list if it's only an empty string
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        editTextName = findViewById(R.id.editTextName);
        editTextArg1 = findViewById(R.id.editTextArg1);
        editTextArg2 = findViewById(R.id.editTextArg2);
        textViewName = findViewById(R.id.textViewName);
        textViewNone = findViewById(R.id.textViewNone);
        textViewSum = findViewById(R.id.textViewSum);
        textViewZero = findViewById(R.id.textViewZero);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
    }

    private ArrayList<String> entries = new ArrayList<>();

    public void openA2(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putStringArrayListExtra("entries", entries);
        startActivity(intent);
    }

    public void ResultOfAdd(View view) {
        String name = editTextName.getText().toString();
        int num1 = Integer.parseInt(editTextArg1.getText().toString());
        int num2 = Integer.parseInt(editTextArg2.getText().toString());
        int sum = num1 + num2;

        textViewNone.setText("Name: " + name);
        textViewZero.setText("Sum: " + sum);

        String entry = "Name: " + name + ", Sum: " + sum;
        entries.add(entry);
        saveData();
    }

    public void ClearList(View view){
        entries.clear();
        saveData();
        Toast.makeText(MainActivity.this, "List cleared", Toast.LENGTH_SHORT).show();

    }

    public void close(View view){
        System.exit(0);
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Join the list into a single string with a delimiter
        String joinedString = TextUtils.join(",", entries);

        editor.putString("entries list", joinedString);
        editor.apply();
    }
}