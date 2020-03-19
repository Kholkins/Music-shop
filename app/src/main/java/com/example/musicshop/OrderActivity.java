package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

       setTitle("You order");

        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userName");
        String goodsName = orderIntent.getStringExtra("goodsName");
        int quantity = orderIntent.getIntExtra("quantity", 0);
        double orderPrice = orderIntent.getDoubleExtra("orderPrice", 0);
        textView = (TextView)findViewById(R.id.userNameTextView);
        textView.setText("Customer name: "+userName + "\nGoods name: "+ goodsName + "\nQuantity: "+ quantity + "\nPrice: "+ orderPrice/quantity + "\nOder price: " + orderPrice);

    }
}
