package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatSentMessage extends AppCompatActivity {
    TextView name;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_sent_message);

        name = (TextView)findViewById(R.id.name);
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
