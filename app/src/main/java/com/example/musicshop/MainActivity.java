package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView quantityNumberTextView;
    private TextView priceTextView;
    private Spinner spinner;
    private ImageView goodsImageView;
    private EditText nameEditText;

    private int quantity;
    private ArrayList spinnerArrayList;
    private ArrayAdapter spinnerAdapter;
    private HashMap goodsMap;
    private String goodsName;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMap();

        createSpinner();

        quantityNumberTextView = (TextView)findViewById(R.id.quantityNumberTextView);

        priceTextView = (TextView)findViewById(R.id.priceTextView);

        goodsImageView = (ImageView)findViewById(R.id.goodsImageView);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
    }

    private void createSpinner() {
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("piano");

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void createMap(){
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 750.0);
        goodsMap.put("piano", 1500.0);
    }

    public void decreaseQuantity(View view) {

        if ( quantity > 0 ) {
            quantity--;
        }
        quantityNumberTextView.setText("" + quantity);
        priceTextView.setText(""+ price * quantity);

    }

    public void increaseQuantity(View view) {

        quantity++;
        quantityNumberTextView.setText("" + quantity);
        priceTextView.setText(""+ price * quantity);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        priceTextView.setText(""+ price * quantity);

        switch (goodsName) {
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "piano":
                goodsImageView.setImageResource(R.drawable.piano);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {
        Order order = new Order();
        order.setUserName(nameEditText.getText().toString());
        order.setGoodsName(goodsName);
        order.setQuantity(quantity);
        order.setOrderPrice(price*quantity);
        Log.d("printUserName", order.getUserName());
    }
}
