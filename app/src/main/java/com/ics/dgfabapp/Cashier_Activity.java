package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Cashier_Activity extends AppCompatActivity {
    Toolbar toolbar_cash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_);

        toolbar_cash = (Toolbar) findViewById(R.id.toolbar_cash);
        toolbar_cash.setNavigationIcon(R.drawable.home);
        toolbar_cash.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
