package com.ics.dgfabapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Order_Informations extends AppCompatActivity {
    LinearLayout fullorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__informations);

        fullorder = findViewById(R.id.fullorder);
        fullorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Order_Informations.this, "xfsadf", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Order_Informations.this, Tracked_Order.class);
                startActivity(intent);
            }
        });
     
    }
}
