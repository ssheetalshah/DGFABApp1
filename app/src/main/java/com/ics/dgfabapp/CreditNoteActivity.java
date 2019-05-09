package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CreditNoteActivity extends AppCompatActivity {
    Toolbar toolbar_crd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_note);

        toolbar_crd = (Toolbar)findViewById(R.id.toolbar_crd);
        toolbar_crd.setNavigationIcon(R.drawable.home);
        toolbar_crd.setNavigationOnClickListener(new View.OnClickListener() {
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
