package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class GRNActivity extends AppCompatActivity {
    TextView create_grn;
    ImageView edt1,edt2,edt3;
    Toolbar toolbar_grn;
    LinearLayout grn , grn1,grn2;
    Spinner recpNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grn);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        grn = findViewById(R.id.grn);
        grn1 = findViewById(R.id.gr1);
        grn2 = findViewById(R.id.grn2);
        recpNo = findViewById(R.id.recpNo);
        create_grn =findViewById(R.id.create_grn);

        recpNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position ==1){
                    grn.setVisibility(View.VISIBLE);
                    grn1.setVisibility(View.GONE);
                    grn2.setVisibility(View.GONE);
                }
                 else if(position ==2)
                {
                    grn.setVisibility(View.GONE);
                    grn1.setVisibility(View.VISIBLE);
                    grn2.setVisibility(View.GONE);
                }
                else if(position ==3)
                {
                    grn.setVisibility(View.GONE);
                    grn1.setVisibility(View.GONE);
                    grn2.setVisibility(View.VISIBLE);
                }else {
                    grn.setVisibility(View.VISIBLE);
                    grn1.setVisibility(View.VISIBLE);
                    grn2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        toolbar_grn = (Toolbar)findViewById(R.id.toolbar_grn);
        toolbar_grn.setNavigationIcon(R.drawable.home);
        toolbar_grn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GRNActivity.this, EditGrn.class);
                startActivity(intent);
            }
        });edt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GRNActivity.this, EditGrn.class);
                startActivity(intent);
            }
        });edt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GRNActivity.this, EditGrn.class);
                startActivity(intent);
            }
        });
        create_grn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GRNActivity.this, Create_New_Grn.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
