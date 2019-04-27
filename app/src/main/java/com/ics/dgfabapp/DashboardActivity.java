package com.ics.dgfabapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ics.dgfabapp.Calendar.HorizontalCalendar;
import com.ics.dgfabapp.Calendar.Model.CalendarEvent;
import com.ics.dgfabapp.Calendar.utils.CalendarEventsPredicate;
import com.ics.dgfabapp.Calendar.utils.HorizontalCalendarListener;
import com.ics.dgfabapp.adapter.MyListAdapter;
import com.ics.dgfabapp.model.MyListData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class DashboardActivity extends AppCompatActivity  {
    RecyclerView recycler_view;
    MyListData[] myListData;
    View view;
    Context c;
    Button btn;

    private HorizontalCalendar horizontalCalendar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //   mTextMessage.setText("one");
                    Intent intent = new Intent(DashboardActivity.this, ChatActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    Intent intent2 = new Intent(DashboardActivity.this, DirCateActivity.class);
                    startActivity(intent2);
                    //  mTextMessage.setText("Two");
                    return true;
                case R.id.navigation_dealerlist:
                    Intent intent4 =new Intent(DashboardActivity.this , DealersList.class);
                    startActivity(intent4);
                    // mTextMessage.setText("three");
                    return true;
                case R.id.navigation_profile:
                    //  mTextMessage.setText("four");
                    Intent intent1 = new Intent(DashboardActivity.this, ProfileActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//******************************************************************************************
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /* start 2 months ago from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -2);

        /* end after 2 months from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 2);

        // Default Date set to Today.
        final Calendar defaultSelectedDate = Calendar.getInstance();

        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.LTGRAY, Color.WHITE)
                .colorTextMiddle(Color.LTGRAY, Color.parseColor("#ffd54f"))
                .end()
                .defaultSelectedDate(defaultSelectedDate)
                .addEvents(new CalendarEventsPredicate() {

                    Random rnd = new Random();
                    @Override
                    public List<CalendarEvent> events(Calendar date) {
                        List<CalendarEvent> events = new ArrayList<>();
                        int count = rnd.nextInt(6);

                        for (int i = 0; i <= count; i++){
                            events.add(new CalendarEvent(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)), "event"));
                        }

                        return events;
                    }
                })
                .build();

        Log.i("Default Date", DateFormat.format("EEE, MMM d, yyyy", defaultSelectedDate).toString());

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String selectedDateStr = DateFormat.format("EEE, MMM d, yyyy", date).toString();
                Toast.makeText(DashboardActivity.this, selectedDateStr + " selected!", Toast.LENGTH_SHORT).show();
                Log.i("onDateSelected", selectedDateStr + " - Position = " + position);
            }

        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horizontalCalendar.goToday(false);
            }
        });
        //*********************************************************************************

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

       //  tooltipView = new TooltipView(btn);

        myListData = new MyListData[]{
                new MyListData("Nike INC", R.drawable.prof , "Indore"),
                new MyListData("Lakme Cosmetics", R.drawable.prof ,"Bhopal"),
                new MyListData("Fast Track", R.drawable.prof ,"USA"),
                new MyListData("Ansian Paints", R.drawable.prof ,"Bombay"),
                new MyListData("Peter England", R.drawable.prof , "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

        };
        MyListAdapter adapter = new MyListAdapter(DashboardActivity.this, myListData);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));
        recycler_view.setAdapter(adapter);

     //   mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
