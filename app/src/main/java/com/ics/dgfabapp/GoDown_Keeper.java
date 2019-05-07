package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GoDown_Keeper extends AppCompatActivity {
    Toolbar toolbar_godown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_down__keeper);

        toolbar_godown = (Toolbar)findViewById(R.id.toolbar_godown);
        toolbar_godown.setNavigationIcon(R.drawable.home);
        toolbar_godown.setNavigationOnClickListener(new View.OnClickListener() {
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
