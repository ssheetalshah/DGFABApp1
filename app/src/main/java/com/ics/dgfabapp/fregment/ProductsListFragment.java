package com.ics.dgfabapp.fregment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ics.dgfabapp.R;
import com.ics.dgfabapp.StockActivity;


public class ProductsListFragment extends Fragment {
    private ListView listview;
    StockActivity stockActivity;
    private String productCategory;

    ProgressDialog progessDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stockActivity = (StockActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater
                .inflate(R.layout.productlist, container, false);
        productCategory = stockActivity.getProducts_category();

        listview = (ListView) rootView.findViewById(R.id.products_listview);

        stockActivity.getSupportActionBar().setTitle(productCategory);
        // selecting single ListView item
        ListView lv = listview;
        // listening to single listitem click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });
        return rootView;
    }

    private boolean isProductlistRetrieved = false;

    public boolean isProductlistRetrieved() {
        return isProductlistRetrieved;
    }

    public void setProductlistRetrieved(boolean isProductlistRetrieved) {
        this.isProductlistRetrieved = isProductlistRetrieved;
    }

}
