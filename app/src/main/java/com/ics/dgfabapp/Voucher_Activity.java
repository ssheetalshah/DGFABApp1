package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Voucher_Activity extends AppCompatActivity {
    TextView reciept_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_);


        reciept_tv=findViewById(R.id.reciept_tv);

        reciept_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Voucher_Activity.this,Reciept_Activity.class);
                startActivity(intent);
            }
        });
    }
}
