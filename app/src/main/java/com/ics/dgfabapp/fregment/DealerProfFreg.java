package com.ics.dgfabapp.fregment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ics.dgfabapp.R;

public class DealerProfFreg extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vx = inflater.inflate(R.layout.fragment_dealer_prof_freg, container, false);
        return vx;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
