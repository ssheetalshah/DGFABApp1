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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ics.dgfabapp.DashboardActivity;
import com.ics.dgfabapp.R;


public class SignUpFreg extends Fragment {
    Button signup;
    //  View view;
    Spinner spin;
    String[] country = {"Manufacturer", "Dealers", "Buyers", "Affiliate Marketer"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up_freg, container, false);

        return view;
//        return inflater.inflate(R.layout.fragment_sign_up_freg, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        //  getActivity().setTitle("BookMark List");

        signup = view.findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent);

            }
        });


    }
}
