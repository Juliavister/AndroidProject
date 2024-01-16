package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends BaseActivity {

    private ArrayList<String> entries;
    private CustomListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = findViewById(R.id.ListView1);
        entries = getIntent().getStringArrayListExtra("entries");
        adapter = new CustomListAdapter(this, entries);
        listView.setAdapter(adapter);

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, entries);
        setupListViewListener(listView);

        /**listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapter.getItem(position);
                String[] parts = item.split(","); // Again, assuming a comma delimiter

                if (parts.length >= 2) {
                    String message = "Value 1: " + parts[0] + ", Value 2: " + parts[1];
                    Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    // If the item doesn't have two parts, just show the whole item
                    Toast.makeText(SecondActivity.this, item, Toast.LENGTH_SHORT).show();
                }
            }
        }); **/
    }

    private void setupListViewListener(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = entries.get(position);
                String[] parts = selectedItem.split(","); // Assuming a comma delimiter

                if (parts.length >= 2) {
                    String message = " " + parts[0] + "\n" + " " + parts[1];
                    Toast.makeText(SecondActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    // If the item doesn't have two parts, just show the whole item
                    Toast.makeText(SecondActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**public void makeToast()
        String selectedItem = entries.get(position);
        Toast.makeText(SecondActivity.this, selectedItem, Toast.LENGTH_LONG).show();
    } **/

   /** public void openA3(View view){
        startActivity(new Intent(this, ThirdActivity.class));
    **/

}