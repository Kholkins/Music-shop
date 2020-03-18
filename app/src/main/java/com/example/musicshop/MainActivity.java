package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView quantityNumberTextView;

    private int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityNumberTextView = findViewById(R.id.quantityNumberTextView);
    }

    public void decreaseQuantity(View view) {

        if ( quantity >= 0 ) {
            quantity--;
        }
        quantityNumberTextView.setText("" + quantity);

    }

    public void increaseQuantity(View view) {

        quantity++;
        quantityNumberTextView.setText("" + quantity);
    }


}
