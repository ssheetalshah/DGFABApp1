package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Chain_2 extends AppCompatActivity {
   TextView seechain2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_2);
        seechain2 = findViewById(R.id.seechain2);
        seechain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chain_2.this , SeenProfile.class);
                startActivity(intent);
            }
        });
    }
}
