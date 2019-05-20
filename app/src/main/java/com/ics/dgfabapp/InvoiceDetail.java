package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class InvoiceDetail extends AppCompatActivity {
    TextView getName,getNo,getTime;
    Toolbar toolbar_invdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_detail);

        toolbar_invdetail = (Toolbar) findViewById(R.id.toolbar_invdetail);
        toolbar_invdetail.setNavigationIcon(R.drawable.home);
        toolbar_invdetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        getName = (TextView)findViewById(R.id.getName);
        getNo = (TextView)findViewById(R.id.getNo);
        getTime = (TextView)findViewById(R.id.getTime);

        String my_string=getIntent().getStringExtra("CompanyNmae");
        getName.setText(my_string);

        String my_string1=getIntent().getStringExtra("OrderNo");
        getNo.setText(my_string1);

        String my_string2=getIntent().getStringExtra("Pref");
        getTime.setText(my_string2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
