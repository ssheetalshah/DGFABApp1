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

        dataModels.add(new DataModel("Inv no : 0001 , Fast Track USA , San diego", "Amount : 20,000", "Dispatch Date : 22-05-2019","Docket no : ASR1234"));
        dataModels.add(new DataModel("Inv no : 0002 , Krishna Clothes , Indore", "Amount : 50,000", "Dispatch Date : 30-05-2019","Docket no : POR3455"));
        dataModels.add(new DataModel("Inv no : 0003 , Fast Track USA", "Amount : 1,00,000", "Dispatch Date : 12-06-2019","Docket no : ERR1234"));
        dataModels.add(new DataModel("Inv no : 0004 , Lakme Cosmetics , Bhopal","Amount : 25,000","Dispatch Date : 02-07-2019","Docket no : PKM3456"));
        dataModels.add(new DataModel("Inv no : 0005 , Peter England , Banglore", "Amount : 10,000", "Dispatch Date : 22-05-2019","Docket no : ASR1234"));
        dataModels.add(new DataModel("Inv no : 0006 , D'cot , Indore", "Amount : 30,000", "Dispatch Date : 30-05-2019","Docket no : POR3455"));
        dataModels.add(new DataModel("Inv no : 0007 , Peter England , Banglore", "Amount : 20,000", "Dispatch Date : 22-05-2019","Docket no : ERR1234"));
        dataModels.add(new DataModel("Inv no : 0008 , Krishna Clothes , Indore","Amount : 50,000","Dispatch Date :12-06-2019","Docket no : PKM3456"));
        dataModels.add(new DataModel("Inv no : 0009 , Lakme Cosmetics , Bhopal", "Amount : 1,20,000", "Dispatch Date : 22-05-2019","Docket no : ASR1234"));
        dataModels.add(new DataModel("Inv no : 0001 , Peter England , Banglore", "Amount : 60,000", "Dispatch Date : 22-05-2019","Docket no : POR3455"));
        dataModels.add(new DataModel("Inv no : 0002 , Peter England , Banglore", "Amount : 90,000", "Dispatch Date : 22-05-2019","Docket no : DMR7899"));

        adapter= new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

            Intent intent=new Intent(TotalSalesActivity.this, InvoiceActivity.class);
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
