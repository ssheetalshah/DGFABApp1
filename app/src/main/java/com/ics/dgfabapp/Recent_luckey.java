package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Recent_luckey extends AppCompatActivity {

    Toolbar toolbar_voucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_luckey);


        toolbar_voucher = (Toolbar) findViewById(R.id.toolbar_voucher);
        toolbar_voucher.setNavigationIcon(R.drawable.home);
        toolbar_voucher.setNavigationOnClickListener(new View.OnClickListener() {
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
