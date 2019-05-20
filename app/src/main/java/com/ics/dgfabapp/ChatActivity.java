package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {
    LinearLayout ll_chat;
    Toolbar toolbar_chat;
    TextView student_name_chat,student_nacdme_chat;
    String S,S1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ll_chat = findViewById(R.id.chat_next1);
        student_name_chat = findViewById(R.id.student_name_chat);
        S = student_name_chat.getText().toString();

        student_nacdme_chat = findViewById(R.id.student_nacdme_chat);
        S1 = student_nacdme_chat.getText().toString();

        toolbar_chat = (Toolbar) findViewById(R.id.toolbar_chat);
        toolbar_chat.setNavigationIcon(R.drawable.home);
        toolbar_chat.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        ll_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, ChatSentMessage.class);
                intent.putExtra("dealername", S);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
