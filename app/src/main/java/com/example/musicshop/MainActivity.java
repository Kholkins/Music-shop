package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setText(View view) {
        TextView newText = findViewById(R.id.quantityNumberTextView);
        newText.setText("Hello");
        newText.setBackgroundResource(R.color.colorAccent);
        newText.setTextSize(30);
    }

    public void increaseQuantity(View view) {
    }


}
