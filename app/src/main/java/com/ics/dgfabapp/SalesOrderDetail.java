package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SalesOrderDetail extends AppCompatActivity {
    Toolbar toolbar_sorddetail;
    TextView getName,ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_detail);

        getName = (TextView)findViewById(R.id.getName);
        ord = (TextView)findViewById(R.id.ord);

        toolbar_sorddetail = (Toolbar) findViewById(R.id.toolbar_sorddetail);
        toolbar_sorddetail.setNavigationIcon(R.drawable.home);
        toolbar_sorddetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        String my_string=getIntent().getStringExtra("CompanyNmae");
        getName.setText(my_string);

        String my_string1=getIntent().getStringExtra("OrderNo");
        ord.setText(my_string1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
