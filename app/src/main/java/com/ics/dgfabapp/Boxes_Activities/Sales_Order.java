package com.ics.dgfabapp.Boxes_Activities;

import android.content.Intent;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ics.dgfabapp.R;
import com.ics.dgfabapp.SalesOrderDetail;

public class Sales_Order extends AppCompatActivity {
    MaterialCardView one, two;
    Toolbar toolbar_sale1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__order);

        toolbar_sale1 = (Toolbar) findViewById(R.id.toolbar_sale2);
        toolbar_sale1.setNavigationIcon(R.drawable.home);
        toolbar_sale1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });


        one = (MaterialCardView) findViewById(R.id.one);
        two = (MaterialCardView) findViewById(R.id.two);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sales_Order.this, SalesOrderDetail.class);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sales_Order.this, SalesOrderDetail.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
