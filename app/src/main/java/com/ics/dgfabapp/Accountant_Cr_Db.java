package com.ics.dgfabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

public class Accountant_Cr_Db extends AppCompatActivity {
    Toolbar toolbar_accutant;

    WebView webView, webView1;
    String html = " <!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "  <title>Bootstrap Example</title>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
            "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
            "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "<div class=\"container\">\n" +
            "  <h3>Accounting</h3>\n" +
            "             \n" +
            "  <table class=\"table table-bordered\">\n" +
            "    <thead>\n" +
            "      <tr>\n" +
            "        <th>Ledger</th>\n" +
            "        <th>Credit</th>\n" +
            "        <th>Credit Note</th>\n" +
//            "        <th>Balance </th>\n" +
            "      </tr>\n" +
            "    </thead>\n" +
            "    <tbody>\n" +
            "      <tr>\n" +
            "        <td>Kryptonite Constructions</td>\n" +
            "        <td>Rs. 70000</td>\n" +
            "        <td>abc conferm</td>\n" +
//            "        <td> </td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
//            "        <td>Buyer</td>\n" +
//            "        <td>Rs. 5000</td>\n" +
//            "        <td></td>\n" +
//            "        <td>Rs. 4300 cr </td>\n" +
            "      </tr>\n" +
            "     \n" +
            "    </tbody>\n" +
            "  </table>\n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    String html1 = " <!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "  <title>Bootstrap Example</title>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
            "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
            "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "<div class=\"container\">\n" +
            "  <h2></h2>\n" +
            "             \n" +
            "  <table class=\"table table-bordered\">\n" +
            "    <thead>\n" +
            "      <tr>\n" +
            "        <th>Ledger</th>\n" +
            "        <th>Debit</th>\n" +
            "        <th>Debit Note</th>\n" +
//            "        <th>Balance </th>\n" +
            "      </tr>\n" +
            "    </thead>\n" +
            "    <tbody>\n" +
            "      <tr>\n" +
            "        <td>Zylker India</td>\n" +
            "        <td>Rs. 50000</td>\n" +
            "        <td>abc xyz</td>\n" +
//            "        <td> </td>\n" +
            "      </tr>\n" +
            "      <tr>\n" +
//            "        <td>Buyer</td>\n" +
//            "        <td>Rs. 5000</td>\n" +
//            "        <td></td>\n" +
//            "        <td>Rs. 4300 cr </td>\n" +
            "      </tr>\n" +
            "     \n" +
            "    </tbody>\n" +
            "  </table>\n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "</html>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountant__cr__db);

        toolbar_accutant = (Toolbar) findViewById(R.id.toolbar_accutant);
        toolbar_accutant.setNavigationIcon(R.drawable.home);
        toolbar_accutant.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        webView = findViewById(R.id.account);
        webView.loadData(html, "text/html; charset=UTF-8", null);

        webView1 = findViewById(R.id.account1);
        webView1.loadData(html1, "text/html; charset=UTF-8", null);


//        webView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Accountant_Cr_Db.this,Credit_Note.class);
//                startActivity(intent);
//            }
//        });

        webView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    return false;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(Accountant_Cr_Db.this, Credit_Note.class);
                    startActivity(intent);

                }

                return false;
            }
        });


        webView1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    return false;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(Accountant_Cr_Db.this, Debit_note.class);
                    startActivity(intent);

                }

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
