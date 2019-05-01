package com.ics.dgfabapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ics.dgfabapp.Boxes_Activities.Sales_Order;
import com.ics.dgfabapp.Calendar.HorizontalCalendar;
import com.ics.dgfabapp.Calendar.Model.CalendarEvent;
import com.ics.dgfabapp.Calendar.utils.CalendarEventsPredicate;
import com.ics.dgfabapp.Calendar.utils.HorizontalCalendarListener;
import com.ics.dgfabapp.SeasonManager.SessionManager;
import com.ics.dgfabapp.adapter.MyListAdapter;
import com.ics.dgfabapp.model.MyListData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recycler_view;
    MyListData[] myListData;
    View view;
    Context c;
    TextView sale_inv,invoice_tv,tv_blueInvoice,tv_invoiceGreen;
    Button btn;
   public static String namestatic;
    SessionManager sessionManager;
    LinearLayout admin_choose, ll_admin;
    CardView other_details;
    Spinner spin_category;

    TextView nonsale, nonsaletime, text_Company, pending_sales, salesord3;

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
                    Intent intent3 = new Intent(DashboardActivity.this, DealersList.class);
                    startActivity(intent3);
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
        setContentView(R.layout.activity_dashboard_navigation);
        sessionManager = new SessionManager(DashboardActivity.this);
//******************************************************************************************
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sale_inv = findViewById(R.id.sale_inv);
        /* start 2 months ago from now */
        pending_sales = findViewById(R.id.pending_sales);
        salesord3 = findViewById(R.id.salesord3);
        text_Company = findViewById(R.id.sale_inv);
        invoice_tv = findViewById(R.id.invoice_tv);
        tv_blueInvoice = findViewById(R.id.tv_blueInvoice);
        tv_invoiceGreen = findViewById(R.id.tv_invoiceGreen);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutxyz);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        sale_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, Sales_Order.class);
                startActivity(intent);
            }
        });

        invoice_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, Invoice1.class);
                startActivity(intent);
            }
        });
        tv_blueInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, Invoice2.class);
                startActivity(intent);
            }
        });
        tv_invoiceGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, Invoice3.class);
                startActivity(intent);
            }
        });

        pending_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SalesOrderTwo.class);
                startActivity(intent);
            }
        });
        salesord3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SalesOrderThree.class);
                startActivity(intent);
            }
        }
        );
        admin_choose = (LinearLayout) findViewById(R.id.admin_choose);
        ll_admin = (LinearLayout) findViewById(R.id.ll_admin);

        other_details = (CardView) findViewById(R.id.other_details);
        spin_category = (Spinner) findViewById(R.id.spin_category);
        nonsale = (TextView) findViewById(R.id.nonsale);
        nonsaletime = (TextView) findViewById(R.id.nonsaletime);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
//                .addEvents(new CalendarEventsPredicate() {
//
//                    Random rnd = new Random();
//                    @Override
//                    public List<CalendarEvent> events(Calendar date) {
//                        List<CalendarEvent> events = new ArrayList<>();
//                        int count = rnd.nextInt(6);
//
//                        for (int i = 0; i <= count; i++){
//                            events.add(new CalendarEvent(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)), "event"));
//                        }
//
//                        return events;
//                    }
//                })
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
                               }
        );
        //*********************************************************************************

        spin_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spin_category.getSelectedItem().equals("Sales") || spin_category.getSelectedItem().equals("Manufacturer") || spin_category.getSelectedItem().equals("Dealer")) {
                    other_details.setVisibility(View.GONE);
                    ll_admin.setVisibility(View.VISIBLE);
                }

                if (spin_category.getSelectedItem().equals("Dispatch")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);

                    nonsale.setText("Action For Dispatch ");
                    nonsaletime.setText("2 pm");

                }
                if (spin_category.getSelectedItem().equals("Accountant")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);

                    nonsale.setText("Action For Accountant ");
                    nonsaletime.setText("3 pm");
                }
                if (spin_category.getSelectedItem().equals("Purchase")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);

                    nonsale.setText("Action For Purchase ");
                    nonsaletime.setText("2.30 pm");
                }
                if (spin_category.getSelectedItem().equals("Logistic")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);

                    nonsale.setText("Action For Logistic ");
                    nonsaletime.setText("1 pm");
                }
                if (spin_category.getSelectedItem().equals("IT")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);

                    nonsale.setText("Action For IT ");
                    nonsaletime.setText("4 pm");
                }

                if (spin_category.getSelectedItem().equals("-Select-")) {
                    other_details.setVisibility(View.GONE);
                    ll_admin.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        //*********************************************************************************************

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        //  tooltipView = new TooltipView(btn);
        if (sessionManager.isLoggedIn().equals("Manufacturer")) {
            admin_choose.setVisibility(View.VISIBLE);
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("Sales") || sessionManager.isLoggedIn().equals("Dealer")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("Dispatch")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("Accountant")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("Purchase")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("Logistic")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("IT")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Nike INC", R.drawable.prof, "Indore"),
                            new MyListData("Lakme Cosmetics", R.drawable.prof, "Bhopal"),
                            new MyListData("Fast Track", R.drawable.prof, "USA"),
                            new MyListData("Ansian Paints", R.drawable.prof, "Bombay"),
                            new MyListData("Peter England", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }

        MyListAdapter adapter = new MyListAdapter(DashboardActivity.this, myListData);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(DashboardActivity.this));
        recycler_view.setAdapter(adapter);

        //   mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_wallet) {
            Intent intent = new Intent(DashboardActivity.this, WalletActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_order) {
            Intent intent = new Intent(DashboardActivity.this, Order_Informations.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(DashboardActivity.this, My_tender.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(DashboardActivity.this, ChatActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(DashboardActivity.this, BillingHistory.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(DashboardActivity.this, NavigationActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_addprod) {
            Intent intent = new Intent(DashboardActivity.this, AddProduct.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutxyz);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
