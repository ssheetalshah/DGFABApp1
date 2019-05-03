package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.ics.dgfabapp.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Products_Act extends AppCompatActivity {
    Toolbar toolbar_prodact;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_);

        toolbar_prodact = (Toolbar) findViewById(R.id.toolbar_prodact);
        toolbar_prodact.setNavigationIcon(R.drawable.home);
        toolbar_prodact.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.ex_lv);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(v.getContext() , DashboardActivity.class);
                intent.putExtra("namewa" ,  listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                startActivity(intent);
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Mobiles & Tablets");
        listDataHeader.add("Electronics");
        listDataHeader.add("Fashion");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Sumsung");
        top250.add("IBall");
        top250.add("IPhone");
        top250.add("Micromax");
        top250.add("China Phone");
        top250.add("SmartPhones");
        top250.add("Feacher Phones");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Laptop Stores");
        nowShowing.add("Desktop Stores");
        nowShowing.add("Camera & Accessories");
        nowShowing.add("Storage Device");
        nowShowing.add("Mobile Accessories");
        nowShowing.add("Gaming");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Mens Fashion Store");
        comingSoon.add("Women Fashion Store");
        comingSoon.add("Kids Wear");
        comingSoon.add("Sandals & Floters");
        comingSoon.add("Jewellery");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
