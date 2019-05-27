package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Show_buyer_product extends AppCompatActivity {
    Button filter , sort;
    LinearLayout proid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_buyer_product);
        filter = findViewById(R.id.filter);
        sort = findViewById(R.id.sort);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show_buyer_product.this , Add_Product_Bags.class);
                startActivity(intent);
            }
        });
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show_buyer_product.this , Add_Product_Clothes.class);
                startActivity(intent);
            }
        });
        proid = findViewById(R.id.proid);
        proid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show_buyer_product.this, Check_out.class);
                startActivity(intent);
            }
        });
    }
}
