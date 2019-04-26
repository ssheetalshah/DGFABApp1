package com.ics.dgfabapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ics.dgfabapp.adapter.MyAdapterrr;
import com.ics.dgfabapp.adapter.MyListAdapter;
import com.ics.dgfabapp.model.MyListData;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout proid;
    private static ViewPager mPager;
    Toolbar toolbar_home;
    final int duration = 1500;
    final int pixelsToMove = 500;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.one, R.drawable.newonw};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    Button btn;
    LinearLayout sad;
//    HeaderAdapter madapter;
    private RecyclerView rv_autoScroll;
    private final Runnable SCROLLING_RUNNABLE = new Runnable() {

        @Override
        public void run() {
            rv_autoScroll.smoothScrollBy(pixelsToMove, 0);
            mHandler.postDelayed(this, duration);
        }
    };
    AlertDialog.Builder builder;
    String[] listItems = {"Manufacturer", "Dealer", "Buyer"};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //   mTextMessage.setText("one");
                 /*   Intent intent = new Intent(Navigation.this, ChatActivity.class);
                    startActivity(intent);*/
                    return true;
                case R.id.navigation_dashboard:
                  /*  Intent intent2 = new Intent(Navigation.this, DirCateActivity.class);
                    //   Intent intent2 = new Intent(Navigation.this, Product_SubCategory.class);
                    startActivity(intent2);*/
                    //  mTextMessage.setText("Two");
                    return true;
                case R.id.navigation_dealerlist:
                    // mTextMessage.setText("three");
                    return true;
                case R.id.navigation_profile:
                    Intent intent1 = new Intent(NavigationActivity.this, ProfileActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        builder = new AlertDialog.Builder(this);
        //    c = NavigationActivity.this.view.getContext();
    /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       /* recycler_view = (RecyclerView) findViewById(R.id.recycler_view);


        myListData = new MyListData[]{
                new MyListData("Nike INC", R.drawable.prof),
                new MyListData("Lakme Cosmetics", R.drawable.prof),
                new MyListData("Fast Track", R.drawable.prof),
                new MyListData("Ansian Paints", R.drawable.prof),
                new MyListData("Peter England", R.drawable.prof),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

        };
        MyListAdapter adapter = new MyListAdapter(NavigationActivity.this, myListData);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(NavigationActivity.this));
        recycler_view.setAdapter(adapter);*/


        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapterrr(NavigationActivity.this, XMENArray));
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(NavigationActivity.this);
            builder.setTitle("Please Select Your Type..");

            int checkedItem = 0; //this will checked the item when user open the dialog
            builder.setSingleChoiceItems(listItems, checkedItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(NavigationActivity.this, "Position: " + which + " Value: " + listItems[which], Toast.LENGTH_LONG).show();
                }
            });

            builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(NavigationActivity.this,CompanyList.class);
                    startActivity(intent);
                    dialog.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
