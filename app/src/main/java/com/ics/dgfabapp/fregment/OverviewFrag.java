package com.ics.dgfabapp.fregment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ics.dgfabapp.My_tender;
import com.ics.dgfabapp.R;


public class OverviewFrag extends Fragment {
    LinearLayout tenpro ;
    TextView tentxt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View b = inflater.inflate(R.layout.fragment_overview , container , false);
        tenpro = b.findViewById(R.id.tenpro);
        tentxt= b.findViewById(R.id.tentxt);
        Toast.makeText(getActivity(), "sdfhkjsdfh", Toast.LENGTH_SHORT).show();
        tentxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "jfbhsd", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , My_tender.class);
                startActivity(intent);
            }
        });
        tenpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "jfbhsd", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , My_tender.class);
                startActivity(intent);
            }
        });
        return inflater.inflate(R.layout.fragment_overview, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tenpro = view.findViewById(R.id.tenpro);
        tentxt= view.findViewById(R.id.tentxt);
        Toast.makeText(getActivity(), "pxxxxxxxxxxxxxxxx", Toast.LENGTH_SHORT).show();
        tentxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "jfbhsd", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , My_tender.class);
                startActivity(intent);
            }
        });
        tenpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "jfbhsd", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , My_tender.class);
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);

    }
}
