package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> items;
    TextView textViewName, textViewSum, textViewNone, textViewZero;

    public CustomListAdapter(Context context, ArrayList<String> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_row, parent, false);
        }
        // Get the data item for this position
        String item = getItem(position);
        //String[] parts = item.split(","); // Assuming the two values are separated by a comma

       /** if (parts.length >= 2) {
            textViewNone.setText(parts[0]); // Set the first value
            textViewZero.setText(parts[1]); // Set the second value
        } else {
            // Handle the case where there aren't two parts
            textViewNone.setText(item);
            textViewZero.setText("");
        } **/


        // Lookup view for data population
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewValue = convertView.findViewById(R.id.textViewValue);
        ProgressBar progressBar = convertView.findViewById(R.id.progressBarDecoration);

        // Populate the data into the template view using the data object
        textViewName.setText(item); // Set the name from your item
        //textViewValue.setText(""); // Set some value

        // Return the completed view to render on screen
        return convertView;
    }
}
