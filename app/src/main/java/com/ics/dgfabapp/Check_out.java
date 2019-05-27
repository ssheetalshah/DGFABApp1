package com.ics.dgfabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Check_out extends AppCompatActivity {
    Button place_or, place_add_to_cart;
    Toolbar toolbar_checkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        toolbar_checkout = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_checkout);
        toolbar_checkout.setNavigationIcon(R.drawable.home);
        toolbar_checkout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        place_or = findViewById(R.id.place_or);
        place_add_to_cart = findViewById(R.id.place_add_to_cart);


        place_or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check_out.this, Order_Placed.class);
                startActivity(intent);
            }
        });

        place_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Check_out.this, "Add To Cart Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Check_out.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
