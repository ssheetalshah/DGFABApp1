package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Product_Stock_List extends AppCompatActivity {

    Button transfer_stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__stock__list);

        transfer_stock=findViewById(R.id.transfer_stock);
        transfer_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_Stock_List.this, Choose_Manu_dealer_Stock_Clear.class);
                startActivity(intent);
            }
        });

    }
}
