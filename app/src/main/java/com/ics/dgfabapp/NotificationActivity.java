package com.ics.dgfabapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ics.dgfabapp.adapter.CustomAdapter;
import com.ics.dgfabapp.adapter.NotificationAdapter;
import com.ics.dgfabapp.model.DataModel;
import com.ics.dgfabapp.model.NotiModel;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
    Toolbar toolbar_noti;
    ListView listView;
    ArrayList<NotiModel> notiModels;
    private static NotificationAdapter notificationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar_noti = (Toolbar) findViewById(R.id.toolbar_noti);
        toolbar_noti.setNavigationIcon(R.drawable.home);
        toolbar_noti.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        listView=(ListView)findViewById(R.id.notification);

        notiModels= new ArrayList<>();

        notiModels.add(new NotiModel("Fast Track USA , San diego", "Amount : 20,000", "1","September 23, 2008"));
        notiModels.add(new NotiModel("Krishna Clothes , Indore", "Amount : 50,000", "2","February 9, 2009"));
        notiModels.add(new NotiModel("Fast Track USA", "Amount : 1,00,000", "3","April 27, 2009"));
        notiModels.add(new NotiModel("Lakme Cosmetics , Bhopal","Amount : 25,000","4","September 15, 2009"));
        notiModels.add(new NotiModel("Peter England , Banglore", "Amount : 10,000", "5","October 26, 2009"));
        notiModels.add(new NotiModel("D'cot , Indore", "Amount : 30,000", "8","May 20, 2010"));
        notiModels.add(new NotiModel("Peter England , Banglore", "Amount : 20,000", "9","December 6, 2010"));
        notiModels.add(new NotiModel("Krishna Clothes , Indore","Amount : 50,000","11","February 22, 2011"));
        notiModels.add(new NotiModel("Lakme Cosmetics , Bhopal", "Amount : 1,20,000", "14","October 18, 2011"));
        notiModels.add(new NotiModel("Peter England , Banglore", "Amount : 60,000", "16","July 9, 2012"));
        notiModels.add(new NotiModel("Peter England , Banglore", "Amount : 90,000", "19","October 31, 2013"));

        notificationAdapter= new NotificationAdapter(notiModels,getApplicationContext());

        listView.setAdapter(notificationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                NotiModel notiModel= notiModels.get(position);

                Snackbar.make(view, notiModel.getName()+"\n"+notiModel.getType()+" API: "+notiModel.getVersion_number(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
