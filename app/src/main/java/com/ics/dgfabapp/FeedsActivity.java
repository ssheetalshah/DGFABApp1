package com.ics.dgfabapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ics.dgfabapp.adapter.FeedAdapter;

public class FeedsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar_feeds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);

        toolbar_feeds = (Toolbar)findViewById(R.id.toolbar_prff);
        toolbar_feeds.setNavigationIcon(R.drawable.home);
        toolbar_feeds.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tabLayout=(TabLayout)findViewById(R.id.tab_layout_feed);
        viewPager=(ViewPager)findViewById(R.id.pager_feed);

        tabLayout.addTab(tabLayout.newTab().setText("Following"));
        tabLayout.addTab(tabLayout.newTab().setText("Discover"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        final FeedAdapter feedAdapter = new FeedAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(feedAdapter);

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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
