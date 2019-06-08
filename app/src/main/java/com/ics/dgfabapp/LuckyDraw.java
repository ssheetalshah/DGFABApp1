package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class LuckyDraw extends AppCompatActivity {

    Toolbar toolbar_voucher;
    TextView recent_lucky, history_lucky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_draw);

        recent_lucky=findViewById(R.id.recent_luckey);
        history_lucky=findViewById(R.id.history_luckey);

        toolbar_voucher = (Toolbar) findViewById(R.id.toolbar_voucher);
        toolbar_voucher.setNavigationIcon(R.drawable.home);
        toolbar_voucher.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });


        recent_lucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LuckyDraw.this, Recent_luckey.class);
                startActivity(intent);
            }
        });
        history_lucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LuckyDraw.this, History_luckey.class);
                startActivity(intent);
            }
        });




    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
