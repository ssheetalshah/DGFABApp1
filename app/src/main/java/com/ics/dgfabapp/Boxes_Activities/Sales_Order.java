package com.ics.dgfabapp.Boxes_Activities;

import android.content.Intent;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ics.dgfabapp.NewSalesDetail;
import com.ics.dgfabapp.R;
import com.ics.dgfabapp.SalesOrderDetail;

public class Sales_Order extends AppCompatActivity {
    MaterialCardView one, two;
    Toolbar toolbar_sale1;
    TextView campony,company1;
    TextView  order,order1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__order);

        toolbar_sale1 = (Toolbar) findViewById(R.id.toolbar_sale1);
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
        campony = (TextView) findViewById(R.id.campony);
        company1 = (TextView) findViewById(R.id.company1);
        order = (TextView) findViewById(R.id.order);
        order1 = (TextView) findViewById(R.id.order1);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sales_Order.this, NewSalesDetail.class);
                intent.putExtra("CompanyNmae",campony.getText().toString());
                intent.putExtra("OrderNo",order.getText().toString());
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sales_Order.this, NewSalesDetail.class);
                intent.putExtra("CompanyNmae",company1.getText().toString());
                intent.putExtra("OrderNo",order1.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
