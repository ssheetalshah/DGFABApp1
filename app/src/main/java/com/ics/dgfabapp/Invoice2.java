package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Invoice2 extends AppCompatActivity {
    Toolbar toolbar_inv2;
    TextView companyNmae, area, orderNo, orderDt, prepareOrder;
    TextView companyNmae1, area1, orderNo1, orderDt1, prepareOrder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice2);

        toolbar_inv2 = (Toolbar) findViewById(R.id.toolbar_inv2);
        toolbar_inv2.setNavigationIcon(R.drawable.home);
        toolbar_inv2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        companyNmae = (TextView) findViewById(R.id.companyNmae);
        String text = "<font color=#000000>Compan Name :</font> <font color=#FF929191>Fast Track USA, San diego</font>";
        companyNmae.setText(Html.fromHtml(text));

        area = (TextView) findViewById(R.id.area);
        String textt = "<font color=#000000>Area :</font> <font color=#FF929191>USA San diego</font>";
        area.setText(Html.fromHtml(textt));

        orderNo = (TextView) findViewById(R.id.orderNo);
        String text1 = "<font color=#000000>Invoice no :</font> <font color=#FF929191>000012, 01-05-2019, 8 PM</font>";
        orderNo.setText(Html.fromHtml(text1));

        orderDt = (TextView) findViewById(R.id.orderDt);
        String text2 = "<font color=#000000>Invoice Date/Time :</font> <font color=#FF929191>01-05-2019, 8 PM</font>";
        orderDt.setText(Html.fromHtml(text2));

        prepareOrder = (TextView) findViewById(R.id.prepareOrder);
        String text3 = "<font color=#000000>Preparing By :</font> <font color=#FF929191>100 </font>";
        prepareOrder.setText(Html.fromHtml(text3));

        companyNmae1 = (TextView) findViewById(R.id.companyNmae1);
        String text11 = "<font color=#000000>Company :</font> <font color=#FF929191>Fast Track USA, San diego</font>";
        companyNmae1.setText(Html.fromHtml(text11));

        area1 = (TextView) findViewById(R.id.area1);
        String texttt = "<font color=#000000>Area :</font> <font color=#FF929191>USA San diego</font>";
        area1.setText(Html.fromHtml(texttt));

        orderNo1 = (TextView) findViewById(R.id.orderNo1);
        String text12 = "<font color=#000000>Invoice no :</font> <font color=#FF929191>000013, 01-05-2019, 8 PM<</font>";
        orderNo1.setText(Html.fromHtml(text12));

        orderDt1 = (TextView) findViewById(R.id.orderDt1);
        String text21 = "<font color=#000000>Invoice Date/Time :</font> <font color=#FF929191>01-05-2019, 8 PM</font>";
        orderDt1.setText(Html.fromHtml(text21));

        prepareOrder1 = (TextView) findViewById(R.id.prepareOrder1);
        String text31 = "<font color=#000000>Preparing By :</font> <font color=#FF929191>5</font>";
        prepareOrder1.setText(Html.fromHtml(text31));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
