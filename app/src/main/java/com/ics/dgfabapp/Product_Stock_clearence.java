package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Product_Stock_clearence extends AppCompatActivity {
   TextView stock_clr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__stock_clearence);

        stock_clr=findViewById(R.id.stock_clr);

        stock_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Product_Stock_clearence.this, Product_Stock_List.class);
                startActivity(intent);
            }
        });

    }
}
