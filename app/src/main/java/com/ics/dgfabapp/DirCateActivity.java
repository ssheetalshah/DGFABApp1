package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DirCateActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView ex_lvdir;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dir_cate);
        // get the listview
        ex_lvdir = (ExpandableListView) findViewById(R.id.ex_lvdir);

        // preparing list data
        prepareListData();

       // listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        ex_lvdir.setAdapter(listAdapter);

        // Listview Group click listener
        ex_lvdir.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

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
        ex_lvdir.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        ex_lvdir.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        ex_lvdir.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

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
                // Toast.makeText(DirCateActivity.this, "sdhfbsjhdfbsjhdf", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), Catigories_activities.class);
                intent.putExtra("namewa", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
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
