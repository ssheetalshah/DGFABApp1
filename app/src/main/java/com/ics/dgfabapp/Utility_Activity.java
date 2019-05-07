package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Utility_Activity extends AppCompatActivity {
    Toolbar toolbar_util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility_);

        toolbar_util = (Toolbar)findViewById(R.id.toolbar_util);
        toolbar_util.setNavigationIcon(R.drawable.home);
        toolbar_util.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
