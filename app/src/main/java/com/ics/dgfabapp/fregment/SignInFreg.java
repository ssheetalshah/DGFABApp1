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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.ics.dgfabapp.DashboardActivity;
import com.ics.dgfabapp.LoginActivity;
import com.ics.dgfabapp.Main2Activity;
import com.ics.dgfabapp.NavigationActivity;
import com.ics.dgfabapp.R;
import com.ics.dgfabapp.SeasonManager.SessionManager;


public class SignInFreg extends Fragment implements
        AdapterView.OnItemSelectedListener {
    Button signIn;
    EditText cusid , pass;
    public static String AllKinds;
    LinearLayout seli;
    //  View view;
    Spinner spinalo;
   // SessionManager sessionManager;
   Spinner spin;
    String[] country = {"Manufacturer", "Dealer", "Buyer","Affiliate Marketing"};
   // String[] country = {"Admin", "Sales", "Dispatch","Accountant","Purchase","Logistic" , "IT"};
    public SessionManager sessionManager;
    private Spinner spin_category;

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
     //   seli = view.findViewById(R.id.seli);
        Toast.makeText(getActivity(), "we are in the frag", Toast.LENGTH_SHORT).show();
        spin_category = (Spinner) view.findViewById(R.id.spin_categorypx);
        pass = view.findViewById(R.id.passedt);

//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(spin.getItemAtPosition(position).equals("Buyer"))
//                {
//                    Toast.makeText(view.getContext(), "item wa is"+spin_category.getSelectedItem(), Toast.LENGTH_SHORT).show();
//                    spin_category.setVisibility(View.GONE);
//                }else {
//                    spin_category.setVisibility(View.VISIBLE);
//                    Toast.makeText(view.getContext(), "item wa is"+spin.getSelectedItem(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
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
                if(spin.getItemAtPosition(position).equals("Buyer") ||spin.getItemAtPosition(position).equals("Affiliate Marketing") )
                {
                    Toast.makeText(view.getContext(), "item wa is"+spin_category.getSelectedItem(), Toast.LENGTH_SHORT).show();
              //      seli.setVisibility(View.GONE);
                }else {
//                    seli.setVisibility(View.VISIBLE);
                    Toast.makeText(view.getContext(), "item wa is"+spin.getSelectedItem(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        signIn = view.findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spin.getSelectedItem().equals("Buyer"))
                {
                    Intent intent = new Intent(getActivity(), NavigationActivity.class);
                    startActivity(intent);
                }
                if (spin.getSelectedItem().equals("Affiliate Marketing")) {
                    Intent intent = new Intent(getActivity(), Main2Activity.class);
                    startActivity(intent);

                }
                if(spin.getSelectedItem().equals("Manufacturer") ||spin.getSelectedItem().equals("Dealer") ) {
                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
                    intent.putExtra("spin_category", spin_category.getSelectedItem().toString());
                    startActivity(intent);
                }
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
