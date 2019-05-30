package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChatSentMessage extends AppCompatActivity {
    TextView name;
    String data;
    Button creatorder ,minisite , hotpro,fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_sent_message);
        creatorder = findViewById(R.id.creatorder);
        minisite = findViewById(R.id.minsite);
        hotpro = findViewById(R.id.hotpro);
        name = (TextView)findViewById(R.id.name);
        fav = findViewById(R.id.fav);
        creatorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ChatSentMessage.this , CreateOrder.class);
                startActivity(intent);
            }
        });
        minisite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatSentMessage.this , SeenProfile.class);
                startActivity(intent);
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatSentMessage.this , Show_buyer_product.class);
                startActivity(intent);
            }
        });
        try {
            if (!(getIntent().getExtras().getString("dealername").isEmpty())){
//            data = getIntent().getExtras().getString("Name");
//            data = getIntent().getExtras().getString("Name");
                data = getIntent().getExtras().getString("dealername");

                name.setText(data);
            }else {

            }
        }catch (Exception e)
        {

        }



    }
}
