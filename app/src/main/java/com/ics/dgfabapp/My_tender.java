package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class My_tender extends AppCompatActivity {
    Toolbar toolbar_tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tender);

        toolbar_tender = (Toolbar) findViewById(R.id.toolbar_tender);
        toolbar_tender.setNavigationIcon(R.drawable.home);
        toolbar_tender.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        LinearLayout linearLayout=findViewById(R.id.tender_desct);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(My_tender.this,Tender_Description.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
