package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class SalesOrderThree extends AppCompatActivity {
    Toolbar toolbar_sale3;
    CardView card1,card2;
    TextView companyNmae, area,orderNo, orderDt, prepareOrder;
    TextView companyNmae1,area1, orderNo1, orderDt1, prepareOrder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order_three);

        toolbar_sale3 = (Toolbar) findViewById(R.id.toolbar_sale3);
        toolbar_sale3.setNavigationIcon(R.drawable.home);
        toolbar_sale3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });


        companyNmae = (TextView) findViewById(R.id.companyNmae);
        String text = "<font color=#000000>Company :</font> <font color=#FF929191>Fast Track USA , San diego</font>";
        companyNmae.setText(Html.fromHtml(text));

        area = (TextView) findViewById(R.id.area);
        String textt = "<font color=#000000>Area :</font> <font color=#FF929191>USA San diego</font>";
        area.setText(Html.fromHtml(textt));

        orderNo = (TextView) findViewById(R.id.orderNo);
        String text1 = "<font color=#000000>Time for bill :</font> <font color=#FF929191>9 PM</font>";
        orderNo.setText(Html.fromHtml(text1));

        orderDt = (TextView) findViewById(R.id.orderDt);
        String text2 = "<font color=#000000>Time for tally bill :</font> <font color=#FF929191>8 PM</font>";
        orderDt.setText(Html.fromHtml(text2));

        prepareOrder = (TextView) findViewById(R.id.prepareOrder);
        String text3 = "<font color=#000000>Dispatch Time  :</font> <font color=#FF929191>01:00 PM</font>";
        prepareOrder.setText(Html.fromHtml(text3));

        companyNmae1 = (TextView) findViewById(R.id.companyNmae1);
        String text11 = "<font color=#000000>Company :</font> <font color=#FF929191>Fast Track USA , San diego</font>";
        companyNmae1.setText(Html.fromHtml(text11));

        area1 = (TextView) findViewById(R.id.area1);
        String texttt = "<font color=#000000>Area :</font> <font color=#FF929191>USA San diego</font>";
        area1.setText(Html.fromHtml(texttt));

        orderNo1 = (TextView) findViewById(R.id.orderNo1);
        String text12 = "<font color=#000000>Time for bill :</font> <font color=#FF929191>9 PM</font>";
        orderNo1.setText(Html.fromHtml(text12));

        orderDt1 = (TextView) findViewById(R.id.orderDt1);
        String text21 = "<font color=#000000>Time for tally bill :</font> <font color=#FF929191>8 PM</font>";
        orderDt1.setText(Html.fromHtml(text21));

        prepareOrder1 = (TextView) findViewById(R.id.prepareOrder1);
        String text31 = "<font color=#000000>Dispatch Time :</font> <font color=#FF929191>01:00 PM</font>";
        prepareOrder1.setText(Html.fromHtml(text31));

        card1 = (CardView)findViewById(R.id.card1);
        card2 = (CardView)findViewById(R.id.card2);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalesOrderThree.this,SalesOrderDetail.class);
                intent.putExtra("CompanyNmae",companyNmae.getText().toString());
                intent.putExtra("OrderNo",orderDt.getText().toString());
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalesOrderThree.this,SalesOrderDetail.class);
                intent.putExtra("CompanyNmae",companyNmae1.getText().toString());
                intent.putExtra("OrderNo",orderDt1.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
