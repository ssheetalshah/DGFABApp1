package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class All_Inerested_Players extends AppCompatActivity {
    ImageView messagedr;
    LinearLayout allconnected;
    ImageView adddir;
    TextView needcon;
    Toolbar toolbar_interst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__inerested__players);
        messagedr = findViewById(R.id.messagedr);
        allconnected = findViewById(R.id.allconnected);
        adddir = findViewById(R.id.adddir);
        needcon = findViewById(R.id.needcon);
        adddir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (needcon.getVisibility() == View.GONE) {
                    needcon.setVisibility(View.VISIBLE);
                    adddir.setVisibility(View.GONE);
                } else {
                    needcon.setVisibility(View.GONE);
                    adddir.setVisibility(View.VISIBLE);
                }
            }
        });
        allconnected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_Inerested_Players.this, SeenProfile.class);
                startActivity(intent);
            }
        });
        messagedr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_Inerested_Players.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        toolbar_interst = (Toolbar)findViewById(R.id.toolbar_interst);
        toolbar_interst.setNavigationIcon(R.drawable.home);
        toolbar_interst.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
        needcon.setVisibility(View.GONE);
        adddir.setVisibility(View.VISIBLE);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
