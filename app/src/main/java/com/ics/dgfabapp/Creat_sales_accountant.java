package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Creat_sales_accountant extends AppCompatActivity {
    Toolbar toolbar_createSales;
    TextView changeorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_sales_accountant);
        Toast.makeText(this, "we are here", Toast.LENGTH_SHORT).show();
        toolbar_createSales = (Toolbar) findViewById(R.id.toolbar_createSales);
        toolbar_createSales.setNavigationIcon(R.drawable.home);
        try{

            changeorder.setText(getIntent().getStringExtra("pro"));
        }catch (Exception e)
        {

        }
        toolbar_createSales.setNavigationOnClickListener(new View.OnClickListener() {
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
