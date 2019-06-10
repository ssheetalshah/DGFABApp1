package com.ics.dgfabapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LinkProfile extends AppCompatActivity {
        ImageView edit_pro;
        TextView mycons;
        TextView interest;
        FloatingActionButton fabeditpro;
        Toolbar toolbar_prff;
        SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_profile);

        fabeditpro = findViewById(R.id.fabeditpro);
        edit_pro = findViewById(R.id.edit_pro);
        interest = findViewById(R.id.interest);
        mycons = findViewById(R.id.mycons);
        toolbar_prff = findViewById(R.id.toolbar_prff);
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
        toolbar_prff.setNavigationIcon(getResources().getDrawable(R.drawable.home));
        toolbar_prff.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        searchView = (SearchView)findViewById(R.id.searchh);
        ImageView searchIcon = searchView.findViewById(android.support.v7.appcompat.R.id.search_button);
        searchIcon.setImageDrawable(ContextCompat.getDrawable(LinkProfile.this,R.drawable.search));
        EditText searchEditText = (EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
