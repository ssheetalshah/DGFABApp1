package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class GRNActivity extends AppCompatActivity {
   TextView create_grn;

    Toolbar toolbar_grn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grn);

        create_grn =findViewById(R.id.create_grn);

        toolbar_grn = (Toolbar)findViewById(R.id.toolbar_grn);
        toolbar_grn.setNavigationIcon(R.drawable.home);
        toolbar_grn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        create_grn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GRNActivity.this, Create_New_Grn.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
