package com.ics.dgfabapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ics.dgfabapp.adapter.ProfileAdapter;

import static com.ics.dgfabapp.DashboardActivity.whatsname;

public class SeenProfile extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TextView add_com,dealname;
    TextView create_order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seen_profile);
        dealname = findViewById(R.id.dealname);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.pager);
        create_order=(TextView) findViewById(R.id.create_order);

        create_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(create_order.getText().toString().equals("Create Sales Order"))
                {
                    Intent intent = new Intent(SeenProfile.this , Creat_sales_accountant.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SeenProfile.this,DirCateActivity.class);
                    startActivity(intent);
                }


//                if ()************accountant login******************************
//                Intent intent = new Intent(SeenProfile.this,Creat_sales_accountant.class);
//                startActivity(intent);
            }
        });
//        try {
//            if(whatsname.equals("Accountant"))
//            {
//                create_order.setText("Create Sales Order");
//            }
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        create_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(whatsname.equals("Accountant")) {
                        Intent intent = new Intent(SeenProfile.this, DirCateActivity.class);
                        startActivity(intent);
                    }
                }catch (Exception e)
                {
                    Intent intent = new Intent(SeenProfile.this, CreateOrder.class);
                    startActivity(intent);
                    e.printStackTrace();
                }
            }
        });
        add_com = findViewById(R.id.add_com);
        tabLayout.addTab(tabLayout.newTab().setText("OverView"));
        tabLayout.addTab(tabLayout.newTab().setText("Products"));
        tabLayout.addTab(tabLayout.newTab().setText("Average"));
        tabLayout.addTab(tabLayout.newTab().setText("Analytics"));
        tabLayout.addTab(tabLayout.newTab().setText("Connections"));
        tabLayout.addTab(tabLayout.newTab().setText("Interest"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        dealname.setText(getIntent().getStringExtra("dealname"));
        add_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_com.setText("Connected");
            }
        });
        final ProfileAdapter profileAdapter = new ProfileAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(profileAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
