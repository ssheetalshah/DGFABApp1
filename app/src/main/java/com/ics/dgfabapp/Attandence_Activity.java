package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Attandence_Activity extends AppCompatActivity {
    Toolbar toolbar_atten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attandence_);

        toolbar_atten = (Toolbar) findViewById(R.id.toolbar_atten);
      /*  toolbar_atten.setNavigationIcon(R.drawable.home);
        toolbar_atten.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
