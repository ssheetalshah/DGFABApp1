package com.ics.dgfabapp.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ics.dgfabapp.R;
import com.ics.dgfabapp.model.DataModel;
import com.ics.dgfabapp.model.NotiModel;

import java.util.ArrayList;

public class NotificationAdapter extends ArrayAdapter<NotiModel> implements View.OnClickListener {

    private ArrayList<NotiModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;
    }

    public NotificationAdapter(ArrayList<NotiModel> data, Context context) {
        super(context, R.layout.notification_row, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        NotiModel notiModel=(NotiModel) object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +notiModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        NotiModel notiModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        NotificationAdapter.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new NotificationAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_totalsale, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (NotificationAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(notiModel.getName());
        viewHolder.txtType.setText(notiModel.getType());
        viewHolder.txtVersion.setText(notiModel.getVersion_number());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
