package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

public class InvoiceRaiseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Toolbar toolbar_Invp;
    LinearLayout invoiceview;
    Spinner repNo;
    String[] country = {"-Select-","00011", "00012", "00013", "00014", "00015","00016", "00017", "00018", "00019", "00020"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_raise);

        toolbar_Invp = (Toolbar) findViewById(R.id.toolbar_Invp);
        toolbar_Invp.setNavigationIcon(R.drawable.home);
        toolbar_Invp.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
         repNo = (Spinner) findViewById(R.id.repNo);
        invoiceview = (LinearLayout) findViewById(R.id.invoiceview);
        repNo.setOnItemSelectedListener(this);
       /* if (repNo.equals("-Select-")){
            invoiceview.setVisibility(View.GONE);
            Toast.makeText(this, "Please Select", Toast.LENGTH_SHORT).show();
        }else {
            invoiceview.setVisibility(View.VISIBLE);
        }*/


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        repNo.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
      Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
//        invoiceview.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
