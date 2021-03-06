package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class OccassionActivity extends AppCompatActivity {
    Toolbar toolbar_occu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occassion);

        toolbar_occu = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar_occu);
        toolbar_occu.setNavigationIcon(R.drawable.home);
        toolbar_occu.setNavigationOnClickListener(new View.OnClickListener() {
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
