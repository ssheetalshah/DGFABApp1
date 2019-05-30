package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MeetingDetail extends AppCompatActivity {
    TextView getTime,getName;
    Button btn_ok;
    Toolbar toolbar_metdetail;
    Button nextBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_detail);

        toolbar_metdetail = (Toolbar) findViewById(R.id.toolbar_metdetail);
        toolbar_metdetail.setNavigationIcon(R.drawable.home);
        toolbar_metdetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        getTime = (TextView) findViewById(R.id.getTime);
        getName = (TextView) findViewById(R.id.getName);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        nextBt = (Button) findViewById(R.id.nextBt);

        nextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeetingDetail.this,Calender_Activity.class);
                startActivity(intent);
            }
        });

        String my_string = getIntent().getStringExtra("Meeting");
        getTime.setText(my_string);

        String my_string1 = getIntent().getStringExtra("Name");
        getName.setText(my_string1);

        btn_ok.setOnClickListener(new View.OnClickListener() {
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
