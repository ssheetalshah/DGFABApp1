package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Gst_Audit_Activity extends AppCompatActivity {
    TextView new_audit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst__audit_);


        new_audit=findViewById(R.id.new_audit);

        new_audit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gst_Audit_Activity.this, Create_New_audit.class);
                startActivity(intent);
            }
        });
    }
}
