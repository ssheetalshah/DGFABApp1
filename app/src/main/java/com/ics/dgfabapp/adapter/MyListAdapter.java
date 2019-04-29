package com.ics.dgfabapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ics.dgfabapp.Call_splash_screen;
import com.ics.dgfabapp.ChatActivity;
import com.ics.dgfabapp.NavigationActivity;
import com.ics.dgfabapp.R;
import com.ics.dgfabapp.SeasonManager.SessionManager;
import com.ics.dgfabapp.model.MyListData;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

import de.hdodenhof.circleimageview.CircleImageView;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    SessionManager sessionManager;
    private MyListData[] listdata;
    public Context context;
    SimpleTooltip simpleTooltip ;
    Calendar c = Calendar.getInstance();

    // RecyclerView recyclerView;

    public MyListAdapter(Context c, MyListData[] listdata) {
        this.listdata = listdata;
        context = c;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        sessionManager = new SessionManager(listItem.getContext());
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        int wtf = position + 3;
        if(sessionManager.isLoggedIn().equals("Admin") || sessionManager.isLoggedIn().equals("Sales"))
        {
           holder.action_card.setVisibility(View.VISIBLE);
        }else{
//            if(sessionManager.isLoggedIn().equals("Dispatch"))
            if(position==0) {
                holder.nonsale.setText("Action For " + sessionManager.isLoggedIn());
                holder.nonsaletime.setText("2 PM");
            }
            if(position==1) {
                holder.nonsale.setText("Action For " + sessionManager.isLoggedIn());
                holder.nonsaletime.setText("3 PM");
            }
            if(position==2) {
                holder.nonsale.setText("Action For " + sessionManager.isLoggedIn());
                holder.nonsaletime.setText("4 PM");
            }
            if(position==3) {
                holder.nonsale.setText("Action For " + sessionManager.isLoggedIn());
                holder.nonsaletime.setText("5 PM");
            }    if(position==4) {
                holder.nonsale.setText("Action For " + sessionManager.isLoggedIn());
                holder.nonsaletime.setText("6 PM");
            }


        }
        holder.textView.setText(listdata[position].getDescription().concat(" ").concat(listdata[position].getAddress()));
        holder.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChatActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        if(position ==0)
        {
            holder.phone.setImageResource(R.drawable.phone_red);
          holder.phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                              new SimpleTooltip.Builder(v.getContext())
                            .anchorView(holder.meet)
                            .text("  2 PM")
                            .gravity(Gravity.BOTTOM)
                            .textColor(Color.WHITE)
                            .setHeight(100)
                            .setWidth(150)
                            .showArrow(true)
                            .animated(false)
                            .build()
                            .show();
                              Intent intent =new Intent(v.getContext() , Call_splash_screen.class);
                              v.getContext().startActivity( intent);

                }
            });
        }   if(position ==1)
        {
            holder.chat.setImageResource(R.drawable.message_red);
            holder.chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new SimpleTooltip.Builder(v.getContext())
                            .anchorView(holder.chat)
                            .text("  4 PM")
                            .gravity(Gravity.BOTTOM)
                            .textColor(Color.WHITE)
                            .setHeight(100)
                            .setWidth(150)
                            .showArrow(true)
                            .animated(false)
                            .build()
                            .show();
                    Intent intent =new Intent(v.getContext() , ChatActivity.class);
                    v.getContext().startActivity( intent);

                }
            });
        }   if(position ==2)
        {
            holder.tell.setImageResource(R.drawable.chat_red);
            holder.tell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new SimpleTooltip.Builder(v.getContext())
                            .anchorView(holder.tell)
                            .text("  5 PM")
                            .gravity(Gravity.BOTTOM)
                            .textColor(Color.WHITE)
                            .setHeight(90)
                            .setWidth(150)
                            .showArrow(true)
                            .animated(false)
                            .build()
                            .show();
                    Intent intent =new Intent(v.getContext() , ChatActivity.class);
                    v.getContext().startActivity( intent);
                }
            });

        }   if(position ==3)
        {
            holder.meet.setImageResource(R.drawable.meeting_red);
            holder.meet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new SimpleTooltip.Builder(v.getContext())
                            .anchorView(holder.meet)
                            .text("  6 PM")
                            .gravity(Gravity.BOTTOM)
                            .textColor(Color.WHITE)
                            .setHeight(100)
                            .setWidth(150)
                            .showArrow(true)
                            .animated(false)
                            .build()
                            .show();

                }
            });
        }
        if(position ==4)
        {
            holder.meet.setImageResource(R.drawable.meeting_red);
            holder.meet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new SimpleTooltip.Builder(v.getContext())
                            .anchorView(holder.meet)
                            .text("  6 PM")
                            .gravity(Gravity.BOTTOM)
                            .textColor(Color.WHITE)
                            .setHeight(100)
                            .setWidth(150)
                            .showArrow(true)
                            .animated(false)
                            .build()
                            .show();

                }
            });
        }
      /*  holder.textView2sdf.setText(String.valueOf(wtf).concat("PM"));
//        if(position ==0)
//        {

        if (holder.sessionManager.isLoggedIn().equals("Manufacturer")) {

            holder.textbrand.setText("Dealer");
        } else if (holder.sessionManager.isLoggedIn().equals("Dealer")) {
            holder.textbrand.setText("Manufacturer");
        }
        holder.imageView.setImageResource(R.drawable.prof);
//        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(),DetailsActivity.class);
//                view.getContext().startActivity(intent);
                // Toast.makeText(view.getContext(),"click on item",Toast.LENGTH_LONG).show();
            }
        });
        holder.libelow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Profile_Manu_Dealer.class);
                intent.putExtra("ideaname", holder.textView.getText().toString());
                view.getContext().startActivity(intent);
                // Toast.makeText(view.getContext(),"click on item",Toast.LENGTH_LONG).show();
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        private LinearLayout libelow;
        CardView action_card;
        ImageView phone,meet ,chat,tell;
        TextView nonsale,nonsaletime;
     //   SessionManager sessionManager;
        TextView textView2df, textbrand, textView2sdf;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);

          //  sessionManager = new SessionManager(itemView.getContext());
            this.imageView = (CircleImageView)itemView.findViewById(R.id.dunb_image);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textbrand = itemView.findViewById(R.id.textbrand);
            this.textView2df = itemView.findViewById(R.id.textView2df);
            this.textView2sdf = itemView.findViewById(R.id.textView2sdf);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            libelow = (LinearLayout) itemView.findViewById(R.id.libelow);
            this.phone = (ImageView) itemView.findViewById(R.id.phone);
            this.chat = (ImageView) itemView.findViewById(R.id.chat);
            this.nonsaletime = itemView.findViewById(R.id.nonsaletime);
            this.meet = (ImageView) itemView.findViewById(R.id.meet);
            this.tell = (ImageView) itemView.findViewById(R.id.tell);
            this.action_card  = itemView.findViewById(R.id.action_card);
            this.nonsale = itemView.findViewById(R.id.nonsale);
            //   View yourView = findViewById(R.id.your_view);

        }
    }
}
