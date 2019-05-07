package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GRNActivity extends AppCompatActivity {
    Toolbar toolbar_grn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grn);

        toolbar_grn = (Toolbar)findViewById(R.id.toolbar_grn);
        toolbar_grn.setNavigationIcon(R.drawable.home);
        toolbar_grn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
