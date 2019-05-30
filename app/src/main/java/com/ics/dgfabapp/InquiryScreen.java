package com.ics.dgfabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ics.dgfabapp.adapter.MoviesAdap;
import com.ics.dgfabapp.adapter.MoviesAdapter;
import com.ics.dgfabapp.model.Moviee;

import java.util.ArrayList;
import java.util.List;

public class InquiryScreen extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] country = {"Inquiries", "Sent", "Unread(99+)", "Trash", "Spam"};
    private ArrayList<Moviee> movieList;
    private RecyclerView recyclerView;
    private MoviesAdap mAdapter;
    Toolbar toolbar_inq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_screen);


        toolbar_inq = (Toolbar) findViewById(R.id.toolbar_inq);
        toolbar_inq.setNavigationIcon(R.drawable.home);
        toolbar_inq.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        movieList = new ArrayList<>();
        mAdapter = new MoviesAdap(movieList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Moviee moviee = movieList.get(position);
                Toast.makeText(getApplicationContext(), moviee.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void prepareMovieData() {
        Moviee moviee = new Moviee("Jason Li", "Top and relative quotation recommend", "5/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Tina yao", "Top and relative quotation recommend", "8/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Jason Li", "Top and relative quotation recommend", "10/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Tina yao", "Top and relative quotation recommend", "11/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Jason Li", "Top and relative quotation recommend", "5/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Mission: Impossible Rogue Nation", "Top and relative quotation recommend", "13/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Up", "Top and relative quotation recommend", "25/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Star Trek", "Top and relative quotation recommend", "25/5/19");
        movieList.add(moviee);

        moviee = new Moviee("The LEGO Movie", "Top and relative quotation recommend", "5/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Iron Man", "Top and relative quotation recommend", "5/5/19");
        movieList.add(moviee);

        moviee = new Moviee("Aliens", "Top and relative quotation recommend", "5/5/19");
        movieList.add(moviee);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

