package com.ics.dgfabapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ics.dgfabapp.adapter.MyListAdapter;
import com.ics.dgfabapp.model.MyListData;


public class DashboardActivity extends AppCompatActivity  {
    RecyclerView recycler_view;
    MyListData[] myListData;
    View view;
    Context c;
    Button btn;

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
                case R.id.navigation_notifications:
                    // mTextMessage.setText("three");
                    return true;
                case R.id.navigation_profile:
                    //  mTextMessage.setText("four");
                    Intent intent1 = new Intent(DashboardActivity.this, ProfileActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

       //  tooltipView = new TooltipView(btn);

        myListData = new MyListData[]{
                new MyListData("Nike INC", R.drawable.prof , "Indore"),
                new MyListData("Lakme Cosmetics", R.drawable.prof ,"Bhopal"),
                new MyListData("Fast Track", R.drawable.prof ,"USA"),
                new MyListData("Ansian Paints", R.drawable.prof ,"Bombay"),
                new MyListData("Peter England", R.drawable.prof , "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

        };
        MyListAdapter adapter = new MyListAdapter(DashboardActivity.this, myListData);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));
        recycler_view.setAdapter(adapter);

     //   mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
