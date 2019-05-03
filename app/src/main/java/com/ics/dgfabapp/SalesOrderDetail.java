package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SalesOrderDetail extends AppCompatActivity {
    Toolbar toolbar_sorddetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_detail);

        toolbar_sorddetail = (Toolbar) findViewById(R.id.toolbar_sorddetail);
        toolbar_sorddetail.setNavigationIcon(R.drawable.home);
        toolbar_sorddetail.setNavigationOnClickListener(new View.OnClickListener() {
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
