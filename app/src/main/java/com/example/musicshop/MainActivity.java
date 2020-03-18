package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView quantityNumberTextView;
    private Spinner spinner;

    private int quantity;
    private ArrayList spinnerArrayList;
    private ArrayAdapter spinnerAdapter;
    private HashMap goodsMap;
    private String goodsName;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goodsMap = new HashMap();
        goodsMap.put("guitar", 500);
        goodsMap.put("drums", 750);
        goodsMap.put("organ", 1500);



        setContentView(R.layout.activity_main);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
