package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DebitNoteActivity extends AppCompatActivity {
    Toolbar toolbar_deb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_note2);

        toolbar_deb = (Toolbar)findViewById(R.id.toolbar_deb);
        toolbar_deb.setNavigationIcon(R.drawable.home);
        toolbar_deb.setNavigationOnClickListener(new View.OnClickListener() {
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
