package com.ics.dgfabapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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
    public static String whatsname;
    Menu nav_Menu;
    Context c;
    TextView sale_inv, invoice_tv, tv_blueInvoice, tv_invoiceGreen;
    Button btn;
    public static String namestatic;
    SessionManager sessionManager;
    LinearLayout admin_choose, ll_admin;
    CardView other_details;
    public static String spin_category;

    Spinner spin_categorypx;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    LinearLayout orderli;
    TextView totalSale;
    Spinner spin_admin_category;

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
        spin_category = getIntent().getStringExtra("spin_category");
        Toast.makeText(DashboardActivity.this, "sub "+spin_category, Toast.LENGTH_SHORT).show();
//******************************************************************************************
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sale_inv = findViewById(R.id.sale_inv);
        /* start 2 months ago from now */
        pending_sales = findViewById(R.id.pending_sales);
        salesord3 = findViewById(R.id.salesord3);
        spin_categorypx = findViewById(R.id.spin_category1);
        text_Company = findViewById(R.id.sale_inv);
        invoice_tv = findViewById(R.id.invoice_tv);
        tv_blueInvoice = findViewById(R.id.tv_blueInvoice);
        orderli = findViewById(R.id.orderli);
        admin_choose = (LinearLayout) findViewById(R.id.admin_choose);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewabc);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView = (NavigationView) findViewById(R.id.nav_viewabc);
        nav_Menu = navigationView.getMenu();
        ll_admin = (LinearLayout) findViewById(R.id.ll_admin);
        orderli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "sgdfdgdfgdfg", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this , SeenProfile.class);
                intent.putExtra("dealname", "Nike Inc");

                v.getContext().startActivity(intent);
            }
        });
        ll_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "xzfdxgdfgdcgfxdfg", Toast.LENGTH_SHORT).show();
            }
        });
        other_details = (CardView) findViewById(R.id.other_details);

        nonsale = (TextView) findViewById(R.id.nonsale);
        nonsaletime = (TextView) findViewById(R.id.nonsaletime);
        tv_invoiceGreen = findViewById(R.id.tv_invoiceGreen);
        totalSale = findViewById(R.id.totalSale);
        spin_admin_category=findViewById(R.id.spin_category1);
        if(spin_category.equals("Admin"))
        {
            spin_categorypx.setSelection(1);
        } else
            {
            if(spin_category.equals("Sales"))
            {
                spin_categorypx.setSelection(2);
                spin_category =  spin_categorypx.getSelectedItem().toString();
                spin_categorypx.setVisibility(View.INVISIBLE);
                nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                nav_Menu.findItem(R.id.nav_department).setVisible(false);
                nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
//                nav_Menu.findItem(R.id.nav_slideshow).setVisible(false);
            //    spin_categorypx.setVisibility(View.GONE);
            }
            if(spin_category.equals("Dispatch"))
            {
                spin_categorypx.setSelection(3);
                spin_category =  spin_categorypx.getSelectedItem().toString();
                spin_categorypx.setVisibility(View.INVISIBLE);
                nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                nav_Menu.findItem(R.id.nav_department).setVisible(false);
                nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
                nav_Menu.findItem(R.id.nav_slideshow).setVisible(false);
             //   spin_categorypx.setVisibility(View.GONE);
            }
            if(spin_category.equals("Accountant"))
            {
                spin_categorypx.setSelection(4);
                spin_category =  spin_categorypx.getSelectedItem().toString();
             //   spin_categorypx.setVisibility(View.GONE);
                whatsname = "Accountant";
                spin_categorypx.setVisibility(View.INVISIBLE);
                nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                nav_Menu.findItem(R.id.nav_department).setVisible(false);
                nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
                nav_Menu.findItem(R.id.nav_slideshow).setVisible(false);
            }
            if(spin_category.equals("Purchase"))
            {
                spin_categorypx.setSelection(5);
                spin_category =  spin_categorypx.getSelectedItem().toString();
             //   spin_categorypx.setVisibility(View.GONE);
                spin_categorypx.setVisibility(View.INVISIBLE);
                nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                nav_Menu.findItem(R.id.nav_department).setVisible(false);
                nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);

            } if(spin_category.equals("Logistic"))
            {
                spin_categorypx.setSelection(6);
                spin_category =  spin_categorypx.getSelectedItem().toString();
                spin_categorypx.setVisibility(View.INVISIBLE);
                nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                nav_Menu.findItem(R.id.nav_department).setVisible(false);
                nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
              //  spin_categorypx.setVisibility(View.GONE);
            } if(spin_category.equals("IT"))
            {
                spin_categorypx.setSelection(7);
                spin_category =  spin_categorypx.getSelectedItem().toString();
                spin_categorypx.setVisibility(View.INVISIBLE);
                nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                nav_Menu.findItem(R.id.nav_department).setVisible(false);
                nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);


            }
        //
        }


        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -2);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutxyz);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        spin_categorypx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DashboardActivity.this, ""+spin_categorypx.getSelectedItem(), Toast.LENGTH_SHORT).show();
                if ( spin_categorypx.getSelectedItem().equals("Sales")) {
                    Toast.makeText(DashboardActivity.this, "sales os", Toast.LENGTH_SHORT).show();
                    other_details.setVisibility(View.GONE);
                    ll_admin.setVisibility(View.VISIBLE);
                    nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                    nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                    nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                    nav_Menu.findItem(R.id.nav_department).setVisible(false);
                    nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                    nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                    nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
                }

                if (spin_categorypx.getSelectedItem().equals("Dispatch")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);
                    recycler_view.setVisibility(View.GONE);
                    nonsale.setText("Action For Dispatch ");
                    nonsaletime.setText("2 pm");
                    nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                    nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                    nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                    nav_Menu.findItem(R.id.nav_department).setVisible(false);
                    nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                    nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                    nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);

                }
                if (spin_categorypx.getSelectedItem().equals("Accountant")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);
                    nonsale.setText("Action For Accountant ");
                    nonsaletime.setText("3 pm");

                }
                if ( spin_categorypx.getSelectedItem().equals("Purchase")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);
                    nonsale.setText("Action For Purchase ");
                    nonsaletime.setText("2.30 pm");
                }
                if (spin_categorypx.getSelectedItem().equals("Logistic")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);
                    nonsale.setText("Action For Logistic ");
                    nonsaletime.setText("1 pm");
                    nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                    nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                    nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                    nav_Menu.findItem(R.id.nav_department).setVisible(false);

                    nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                    nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
                }
                if ( spin_categorypx.getSelectedItem().equals("IT")) {
                    other_details.setVisibility(View.VISIBLE);
                    ll_admin.setVisibility(View.GONE);
                    nonsale.setText("Action For IT ");
                    nonsaletime.setText("4 pm");
                    nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                    nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                    nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                    nav_Menu.findItem(R.id.nav_department).setVisible(false);

                    nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                    nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
                }

                if (spin_category.equals("-Select-") || spin_category.equals("Admin") ) {
                    other_details.setVisibility(View.GONE);
                    ll_admin.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

        totalSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, TotalSalesActivity.class);
                startActivity(intent);
            }
        });

       /* listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);*/



         navigationView = (NavigationView) findViewById(R.id.nav_viewabc);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView = (NavigationView) findViewById(R.id.nav_viewabc);
         nav_Menu = navigationView.getMenu();
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
        spin_admin_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spin_admin_category.getItemAtPosition(position).equals("Sales")) {
                    other_details.setVisibility(View.GONE);
                    ll_admin.setVisibility(View.VISIBLE);
//                    Toast.makeText(c, "sales", Toast.LENGTH_SHORT).show();
                    nav_Menu.findItem(R.id.nav_accountant).setVisible(false);
                    nav_Menu.findItem(R.id.nav_Attandence).setVisible(false);
                    nav_Menu.findItem(R.id.nav_cashier).setVisible(false);
                    nav_Menu.findItem(R.id.nav_department).setVisible(false);
                    nav_Menu.findItem(R.id.nav_gownkeeper).setVisible(false);
                    nav_Menu.findItem(R.id.nav_occassion).setVisible(false);
                    nav_Menu.findItem(R.id.nav_stock_Clear).setVisible(false);
                }
                if (spin_admin_category.getItemAtPosition(position).equals("Admin")) {
                    other_details.setVisibility(View.GONE);
                    ll_admin.setVisibility(View.VISIBLE);
                }

                    if (spin_admin_category.getItemAtPosition(position).equals("Dispatch")) {
                        other_details.setVisibility(View.VISIBLE);
                        ll_admin.setVisibility(View.GONE);

                        nonsale.setText("Action For Dispatch ");
                        nonsaletime.setText("2 pm");

                    }
                    if (spin_admin_category.getItemAtPosition(position).equals("Accountant")) {
                        other_details.setVisibility(View.VISIBLE);
                        ll_admin.setVisibility(View.GONE);

                        nonsale.setText("Action For Accountant ");
                        nonsaletime.setText("3 pm");
                    }
                    if (spin_admin_category.getItemAtPosition(position).equals("Purchase")) {
                        other_details.setVisibility(View.VISIBLE);
                        ll_admin.setVisibility(View.GONE);

                        nonsale.setText("Action For Purchase ");
                        nonsaletime.setText("2.30 pm");
                    }
                    if (spin_admin_category.getItemAtPosition(position).equals("Logistic")) {
                        other_details.setVisibility(View.VISIBLE);
                        ll_admin.setVisibility(View.GONE);

                        nonsale.setText("Action For Logistic ");
                        nonsaletime.setText("1 pm");
                    }
                    if (spin_admin_category.getItemAtPosition(position).equals("IT")) {
                        other_details.setVisibility(View.VISIBLE);
                        ll_admin.setVisibility(View.GONE);

                        nonsale.setText("Action For IT ");
                        nonsaletime.setText("4 pm");
                    }

                    if (spin_admin_category.getItemAtPosition(position).equals("-Select-")) {
                        other_details.setVisibility(View.GONE);
                        ll_admin.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //*****************************************************************************


//        if (spin_category.equals("Sales") || spin_category.equals("Manufacturer") || spin_category.equals("Dealer") ) {
//            other_details.setVisibility(View.GONE);
//            ll_admin.setVisibility(View.VISIBLE);
//        }
//
//        if (spin_category.equals("Dispatch") ) {
//            other_details.setVisibility(View.VISIBLE);
//            ll_admin.setVisibility(View.GONE);
//
//            nonsale.setText("Action For Dispatch ");
//            nonsaletime.setText("2 pm");
//
//        }
//        if (spin_category.equals("Accountant") ) {
//            other_details.setVisibility(View.VISIBLE);
//            ll_admin.setVisibility(View.GONE);
//
//            nonsale.setText("Action For Accountant ");
//            nonsaletime.setText("3 pm");
//        }
//        if (spin_category.equals("Purchase") ) {
//            other_details.setVisibility(View.VISIBLE);
//            ll_admin.setVisibility(View.GONE);
//
//            nonsale.setText("Action For Purchase ");
//            nonsaletime.setText("2.30 pm");
//        }
//        if (spin_category.equals("Logistic") ) {
//            other_details.setVisibility(View.VISIBLE);
//            ll_admin.setVisibility(View.GONE);
//
//            nonsale.setText("Action For Logistic ");
//            nonsaletime.setText("1 pm");
//        }
//        if (spin_category.equals("IT")) {
//            other_details.setVisibility(View.VISIBLE);
//            ll_admin.setVisibility(View.GONE);
//
//            nonsale.setText("Action For IT ");
//            nonsaletime.setText("4 pm");
//        }
//
//        if (spin_category.equals("-Select-") ) {
//            other_details.setVisibility(View.GONE);
//            ll_admin.setVisibility(View.VISIBLE);
//        }
//

        //*********************************************************************************************

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);


        //  tooltipView = new TooltipView(btn);
        if (sessionManager.isLoggedIn().equals("Manufacturer") || sessionManager.isLoggedIn().equals("Dealer") ) {
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
        if (sessionManager.isLoggedIn().equals("Sales")) {
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

        //    nav_Menu.findItem(R.id.nav_).setVisible(false);

        }
        if (sessionManager.isLoggedIn().equals("Dispatch")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Om Logistics LTD.", R.drawable.prof, "Indore"),
                            new MyListData("Girnar Logistics Pvt. Ltd.", R.drawable.prof, "Bhopal"),
                            new MyListData("Inland World Logistics", R.drawable.prof, "USA"),
                            new MyListData("B.R.C. Logistics", R.drawable.prof, "Bombay"),
                            new MyListData("CCI Logistics Ltd", R.drawable.prof, "Bangalore"),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

                    };
        }
        if (sessionManager.isLoggedIn().equals("Accountant")) {
            myListData = new MyListData[]
                    {
                            new MyListData("Parag Sharma", R.drawable.prof, "Indore"),
                            new MyListData("Sheetal Somesh", R.drawable.prof, "Bhopal"),
                            new MyListData("Vivek Kale", R.drawable.prof, "USA"),
                            new MyListData("Krishna", R.drawable.prof, "Bombay"),

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
                            new MyListData("Nilesh", R.drawable.prof, "Indore"),
                            new MyListData("Pankaj ", R.drawable.prof, "Bhopal"),
                            new MyListData("Raghvendra", R.drawable.prof, "USA"),
                            new MyListData("Raj", R.drawable.prof, "Bombay")
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navimenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.app_bar_search) {

            return true;
        }

        if (id == R.id.app_bar_notification) {
            Intent intent = new Intent(DashboardActivity.this,NotificationActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
        }if(id == R.id.nav_follow)
        {
          Intent intent = new Intent(DashboardActivity.this , Followers.class);
          startActivity(intent);
        }
        else if (id == R.id.nav_wallet) {
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
        }else if (id == R.id.nav_accountant) {
            Intent intent = new Intent(DashboardActivity.this, Accountant_Cr_Db.class);
            startActivity(intent);
        }else if (id == R.id.nav_Attandence) {
            Intent intent = new Intent(DashboardActivity.this, Attandence_Activity.class);
            startActivity(intent);
        }else if (id == R.id.nav_cashier) {
            Intent intent = new Intent(DashboardActivity.this, Cashier_Activity.class);
            startActivity(intent);
        }else if (id == R.id.nav_gownkeeper) {
            Intent intent = new Intent(DashboardActivity.this, GoDown_Keeper.class);
            startActivity(intent);
        }else if (id == R.id.nav_department) {
            Intent intent = new Intent(DashboardActivity.this, Department_Activity.class);
            startActivity(intent);
        }else if (id == R.id.nav_occassion) {
            Intent intent = new Intent(DashboardActivity.this, OccassionActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_stock_Clear) {
            Intent intent = new Intent(DashboardActivity.this, Product_Stock_clearence.class);
            startActivity(intent);
        } else if (id == R.id.nav_grn) {
            Intent intent = new Intent(DashboardActivity.this, GRNActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutxyz);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
