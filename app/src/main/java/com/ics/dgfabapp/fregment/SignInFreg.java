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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ics.dgfabapp.DashboardActivity;
import com.ics.dgfabapp.LoginActivity;
import com.ics.dgfabapp.R;
import com.ics.dgfabapp.SeasonManager.SessionManager;


public class SignInFreg extends Fragment implements
        AdapterView.OnItemSelectedListener {
    Button signIn;
    EditText cusid , pass;
    //  View view;
    Spinner spinalo;
   // SessionManager sessionManager;
   Spinner spin;
    String[] country = {"Admin", "Sales", "Dispatch","Accountant","Purchase","Logistic" , "IT"};
    public SessionManager sessionManager;

    public SignInFreg() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vx = inflater.inflate(R.layout.fragment_sign_in_freg, container, false);

        return vx;

//        return inflater.inflate(R.layout.fragment_sign_in_freg, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        //  getActivity().setTitle("BookMark List");
        spin = view.findViewById(R.id.spinalo);
        cusid = view.findViewById(R.id.cusid);
        pass = view.findViewById(R.id.passedt);

        sessionManager = new SessionManager(getActivity());
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
//        spin = (Spinner)view.findViewById(R.id.spin12);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.custom_spinner , country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sessionManager.setLogin(true,spin.getItemAtPosition(position).toString());
                cusid.setText(spin.getItemAtPosition(position).toString());
                pass.setText(spin.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        signIn = view.findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
