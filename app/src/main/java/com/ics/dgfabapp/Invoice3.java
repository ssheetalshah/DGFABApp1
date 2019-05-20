package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Invoice3 extends AppCompatActivity {
    CardView crd1, crd2;
    Toolbar toolbar_inv3;
    TextView companyNmae, area, orderNo, orderDt, prepareOrder;
    TextView companyNmae1, area1, orderNo1, orderDt1, prepareOrder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice3);

        toolbar_inv3 = (Toolbar) findViewById(R.id.toolbar_inv3);
        toolbar_inv3.setNavigationIcon(R.drawable.home);
        toolbar_inv3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
        companyNmae = (TextView) findViewById(R.id.companyNmae);
        String text = "<font color=#000000>Company :</font> <font color=#FF929191>Fast Track USA, San diego</font>";
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
        String text3 = "<font color=#000000>Dispatch By :</font> <font color=#FF929191>100 </font>";
        prepareOrder.setText(Html.fromHtml(text3));

        companyNmae1 = (TextView) findViewById(R.id.companyNmae1);
        String text11 = "<font color=#000000>Company :</font> <font color=#FF929191>Fast Track USA, San diego</font>";
        companyNmae1.setText(Html.fromHtml(text11));

        area1 = (TextView) findViewById(R.id.area1);
        String texttt = "<font color=#000000>Area :</font> <font color=#FF929191>USA San diego</font>";
        area1.setText(Html.fromHtml(texttt));

        orderNo1 = (TextView) findViewById(R.id.orderNo1);
        String text12 = "<font color=#000000>Invoice no :</font> <font color=#FF929191>000013, 01-05-2019, 8 PM</font>";
        orderNo1.setText(Html.fromHtml(text12));

        orderDt1 = (TextView) findViewById(R.id.orderDt1);
        String text21 = "<font color=#000000>Invoice Date/Time :</font> <font color=#FF929191>01-05-2019, 8 PM</font>";
        orderDt1.setText(Html.fromHtml(text21));

        prepareOrder1 = (TextView) findViewById(R.id.prepareOrder1);
        String text31 = "<font color=#000000>Dispatch By:</font> <font color=#FF929191>5</font>";
        prepareOrder1.setText(Html.fromHtml(text31));

        crd1 = (CardView)findViewById(R.id.crd1);
        crd2 = (CardView)findViewById(R.id.crd2);

        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Invoice3.this, InvoiceDetail.class);
                intent.putExtra("CompanyNmae", companyNmae.getText().toString());
                intent.putExtra("OrderNo", orderNo.getText().toString());
                intent.putExtra("Pref",prepareOrder.getText().toString());
                startActivity(intent);
            }
        });
        crd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Invoice3.this, InvoiceDetail.class);
                intent.putExtra("CompanyNmae", companyNmae1.getText().toString());
                intent.putExtra("OrderNo", orderNo1.getText().toString());
                intent.putExtra("Pref",prepareOrder1.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
