package com.ics.dgfabapp;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ics.dgfabapp.adapter.MyListAdapter;
import com.ics.dgfabapp.model.MyListData;


public class DashboardActivity extends AppCompatActivity  {
    RecyclerView recycler_view;
    MyListData[] myListData;
    View view;
    Context c;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

       //  tooltipView = new TooltipView(btn);

        myListData = new MyListData[]{
                new MyListData("Nike INC", R.drawable.prof),
                new MyListData("Lakme Cosmetics", R.drawable.prof),
                new MyListData("Fast Track", R.drawable.prof),
                new MyListData("Ansian Paints", R.drawable.prof),
                new MyListData("Peter England", R.drawable.prof),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

        };
        MyListAdapter adapter = new MyListAdapter(DashboardActivity.this, myListData);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));
        recycler_view.setAdapter(adapter);
    }
}
