package com.ics.dgfabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Order_Placed extends AppCompatActivity {
    Button donbtn;
    ImageView success;
    Toolbar toolbar_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__placed);
        donbtn = findViewById(R.id.donbtn);

        toolbar_success = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_success);
        toolbar_success.setNavigationIcon(R.drawable.home);
        toolbar_success.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //***********animation Bounce
        final Animation bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        success = (ImageView) findViewById(R.id.success);
        success.startAnimation(bounce);

        donbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Placed.this, NavigationActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
