package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Chain_chain extends AppCompatActivity {
        TextView seechain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_chain);
        seechain = findViewById(R.id.seechain);
        seechain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chain_chain.this ,Chain_2.class);
                startActivity(intent);
            }
        });
    }
}
