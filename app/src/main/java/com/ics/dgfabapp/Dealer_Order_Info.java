package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dealer_Order_Info extends AppCompatActivity {
    TextView ortxid;
    Button oktk;
    Toolbar toolbar_dealOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer__order__info);

        toolbar_dealOrd = (Toolbar) findViewById(R.id.toolbar_dealOrd);
        toolbar_dealOrd.setNavigationIcon(R.drawable.home);
        toolbar_dealOrd.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        oktk = findViewById(R.id.oktk);
        oktk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dealer_Order_Info.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
//        ortxid.setText("Nike Brand and Nike INC.");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
