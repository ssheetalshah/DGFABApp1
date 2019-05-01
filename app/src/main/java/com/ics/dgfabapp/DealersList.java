package com.ics.dgfabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ics.dgfabapp.fregment.AveragePurchase;
import com.ics.dgfabapp.fregment.DealerProfFreg;


public class DealersList extends AppCompatActivity {
    Toolbar toolbar_dealers;
    TextView addDealer;
    FrameLayout frame_deal;
    LinearLayout to_avli ,hidethatsht,ccccc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers_list);

        to_avli = findViewById(R.id.to_avli);
        ccccc = findViewById(R.id.ccccc);
        frame_deal = findViewById(R.id.frame_deal);
        hidethatsht = findViewById(R.id.hidethatsht);
        addDealer = (TextView)findViewById(R.id.addDealer);
        toolbar_dealers = (Toolbar)findViewById(R.id.toolbar_dealers);
      //  toolbar_dealers.setNavigationIcon(R.drawable.arrow);
        to_avli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            hidethatsht.setVisibility(View.GONE);
                addDealer.setVisibility(View.GONE);
                Intent intent = new Intent(DealersList.this , SeenProfile.class);
                intent.putExtra("dealname" ,"Best Footwear Dealers" );
                startActivity(intent);
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//               fragmentTransaction.replace(R.id.frame_deal ,new DealerProfFreg()).commit();
            }
        });
        ccccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidethatsht.setVisibility(View.GONE);
                addDealer.setVisibility(View.GONE);
                Intent intent = new Intent(DealersList.this , SeenProfile.class);
                intent.putExtra("dealname" ,"Krishna Clothes" );
                startActivity(intent);
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//              fragmentTransaction.replace(R.id.frame_deal ,new DealerProfFreg()).commit();
            }
        });

        toolbar_dealers.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });


        addDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DealersList.this,AddDealer.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
