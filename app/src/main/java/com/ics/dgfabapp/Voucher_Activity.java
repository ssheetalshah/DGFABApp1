package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Voucher_Activity extends AppCompatActivity {
    LinearLayout reciept_tv;
    Toolbar toolbar_voucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_);

        toolbar_voucher = (Toolbar) findViewById(R.id.toolbar_voucher);
        toolbar_voucher.setNavigationIcon(R.drawable.home);
        toolbar_voucher.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        reciept_tv = findViewById(R.id.reciept_tv);

        reciept_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Voucher_Activity.this, Reciept_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
