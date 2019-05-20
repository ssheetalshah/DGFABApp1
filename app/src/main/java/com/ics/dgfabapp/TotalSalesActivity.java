package com.ics.dgfabapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ics.dgfabapp.adapter.CustomAdapter;
import com.ics.dgfabapp.model.DataModel;

import java.util.ArrayList;

public class TotalSalesActivity extends AppCompatActivity {
    Toolbar toolbar_sdetail;
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_sales);

        listView=(ListView)findViewById(R.id.totalSaleList);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Fast Track USA , San diego", "Amount : 20,000", "1","September 23, 2008"));
        dataModels.add(new DataModel("Krishna Clothes , Indore", "Amount : 50,000", "2","February 9, 2009"));
        dataModels.add(new DataModel("Fast Track USA", "Amount : 1,00,000", "3","April 27, 2009"));
        dataModels.add(new DataModel("Lakme Cosmetics , Bhopal","Amount : 25,000","4","September 15, 2009"));
        dataModels.add(new DataModel("Peter England , Banglore", "Amount : 10,000", "5","October 26, 2009"));
        dataModels.add(new DataModel("D'cot , Indore", "Amount : 30,000", "8","May 20, 2010"));
        dataModels.add(new DataModel("Peter England , Banglore", "Amount : 20,000", "9","December 6, 2010"));
        dataModels.add(new DataModel("Krishna Clothes , Indore","Amount : 50,000","11","February 22, 2011"));
        dataModels.add(new DataModel("Lakme Cosmetics , Bhopal", "Amount : 1,20,000", "14","October 18, 2011"));
        dataModels.add(new DataModel("Peter England , Banglore", "Amount : 60,000", "16","July 9, 2012"));
        dataModels.add(new DataModel("Peter England , Banglore", "Amount : 90,000", "19","October 31, 2013"));

        adapter= new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

            Intent intent=new Intent(TotalSalesActivity.this, Total_Sales_details.class);
            startActivity(intent);


                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });

        toolbar_sdetail = (Toolbar) findViewById(R.id.toolbar_sdetail);
        toolbar_sdetail.setNavigationIcon(R.drawable.home);
        toolbar_sdetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
