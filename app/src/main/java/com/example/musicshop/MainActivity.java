package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView quantityNumberTextView;
    private Spinner spinner;

    private int quantity;
    private ArrayList spinnerArrayList;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drum");
        spinnerArrayList.add("organ");

        spinner = (Spinner)findViewById(R.id.spinner);

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);



        quantityNumberTextView = (TextView)findViewById(R.id.quantityNumberTextView);
    }

    public void decreaseQuantity(View view) {

        if ( quantity > 0 ) {
            quantity--;
        }
        quantityNumberTextView.setText("" + quantity);

    }

    public void increaseQuantity(View view) {

        quantity++;
        quantityNumberTextView.setText("" + quantity);
    }


}
