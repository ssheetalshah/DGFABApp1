package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Master_Activity extends AppCompatActivity {
    Toolbar toolbar_master;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_);

        toolbar_master = (Toolbar)findViewById(R.id.toolbar_master);
        toolbar_master.setNavigationIcon(R.drawable.home);
        toolbar_master.setNavigationOnClickListener(new View.OnClickListener() {
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
