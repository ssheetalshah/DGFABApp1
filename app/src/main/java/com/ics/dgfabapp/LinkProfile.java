package com.ics.dgfabapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LinkProfile extends AppCompatActivity {
        ImageView edit_pro;
        TextView mycons;
        TextView interest;
        FloatingActionButton fabeditpro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_profile);
        fabeditpro = findViewById(R.id.fabeditpro);
        edit_pro = findViewById(R.id.edit_pro);
        interest = findViewById(R.id.interest);
        mycons = findViewById(R.id.mycons);
        edit_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinkProfile.this , SeenProfile.class);
                startActivity(intent);
            }
        });
        interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinkProfile.this , All_Inerested_Players.class);
                startActivity(intent);
            }
        });
        mycons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinkProfile.this , Chain_chain.class);
                startActivity(intent);
            }
        });
        edit_pro = findViewById(R.id.edit_pro);
        fabeditpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinkProfile.this , EditProfilebuyer.class);
                startActivity(intent);
            }
        });

    }
}
