package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Accountant_Cr_Db extends AppCompatActivity {

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
            "        <td>Namo Textile Saree Center</td>\n" +
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
            "        <td>Birla cement Center</td>\n" +
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

        webView = findViewById(R.id.account);
        webView.loadData(html, "text/html; charset=UTF-8",null);

        webView1 = findViewById(R.id.account1);
        webView1.loadData(html1, "text/html; charset=UTF-8",null);



    }
}
