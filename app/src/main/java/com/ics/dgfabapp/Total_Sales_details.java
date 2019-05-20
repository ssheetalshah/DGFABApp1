package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Total_Sales_details extends AppCompatActivity {
    Toolbar toolbar_sdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total__sales_details);



        toolbar_sdetail = (Toolbar) findViewById(R.id.toolbar_sdetail);
        toolbar_sdetail.setNavigationIcon(R.drawable.home);
        toolbar_sdetail.setNavigationOnClickListener(new View.OnClickListener() {
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
