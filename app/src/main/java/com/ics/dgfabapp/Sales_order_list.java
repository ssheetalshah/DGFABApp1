package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Sales_order_list extends AppCompatActivity {
    Toolbar toolbar_salesOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_list);


        toolbar_salesOrd = (Toolbar)findViewById(R.id.toolbar_salesOrd);
        toolbar_salesOrd.setNavigationIcon(R.drawable.home);
        toolbar_salesOrd.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
