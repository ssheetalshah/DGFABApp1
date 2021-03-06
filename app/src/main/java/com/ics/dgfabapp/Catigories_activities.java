package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ics.dgfabapp.SeasonManager.AppPreference;

public class Catigories_activities extends AppCompatActivity {
    Toolbar toolbar_catAct;
    String namewa;
    TextView nmae;
    LinearLayout lingo;
    ListView mlist;
    // Array of strings...
    String[] mobileArray = {"Dell Inspiron", "Dell Vostro 3568 Intel Core i3 ", "HP Spectre X360 (13-AP0102TU)", "MSI Laptop Brand",
            "Lenovo ThinkPad X1 Carbon 14 FHD IPS Touchscreen Ultrabook Laptop ", "ALIENWARE M15", "MSI Gaming MSI GT83 8RG-007IN 2018 18.4-inch Laptop (8th Gen "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catigories_activities);

        toolbar_catAct = (Toolbar) findViewById(R.id.toolbar_catAct);
        toolbar_catAct.setNavigationIcon(R.drawable.home);
        toolbar_catAct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
        namewa = getIntent().getStringExtra("namewa");

        nmae = (TextView) findViewById(R.id.nmae);
        nmae.setText(namewa);

       /* lingo = (LinearLayout) findViewById(R.id.lingo);
        lingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Order_Products.class);
                intent.putExtra("namewa", namewa);
                startActivity(intent);
            }
        });*/

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listlist, mobileArray);

        mlist = (ListView) findViewById(R.id.mlist);
        mlist.setAdapter(adapter);


        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                if (AppPreference.getRefid(Catigories_activities.this).equals("1")){
                    Intent intent = new Intent(Catigories_activities.this, Show_buyer_product.class);
                    startActivity(intent);

                }else {


                Intent intent = new Intent(Catigories_activities.this, Creat_sales_accountant.class);
                intent.putExtra("namewa", namewa);
                startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
