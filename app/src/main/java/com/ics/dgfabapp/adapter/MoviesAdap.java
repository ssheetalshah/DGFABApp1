package com.ics.dgfabapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ics.dgfabapp.ChatActivity;
import com.ics.dgfabapp.NewChatActivity;
import com.ics.dgfabapp.R;
import com.ics.dgfabapp.model.Moviee;

import java.util.List;

public class MoviesAdap extends RecyclerView.Adapter<MoviesAdap.MyViewHolder> {
//    private Context context;
    private List<Moviee> moviesList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public RelativeLayout rl;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            rl = (RelativeLayout) view.findViewById(R.id.rl);
        }
    }


    public MoviesAdap(List<Moviee> moviesList) {

        this.moviesList = moviesList;
//        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Moviee moviee = moviesList.get(position);
        holder.title.setText(moviee.getTitle());
        holder.genre.setText(moviee.getGenre());
        holder.year.setText(moviee.getYear());

      /*  holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              *//*  Intent intent = new Intent(context, NewChatActivity.class);
                context.startActivity(intent);*//*
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
