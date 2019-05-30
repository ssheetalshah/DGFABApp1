package com.ics.dgfabapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ics.dgfabapp.FeedsActivity;
import com.ics.dgfabapp.fregment.DiscoverFrag;
import com.ics.dgfabapp.fregment.FollowingFrag;
import com.ics.dgfabapp.fregment.OverviewFrag;
import com.ics.dgfabapp.fregment.ProductFrag;
import com.ics.dgfabapp.fregment.VideosFrag;

public class FeedAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public FeedAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FollowingFrag followingFrag = new FollowingFrag();
                return followingFrag;
            case 1:

                DiscoverFrag discoverFrag = new DiscoverFrag();
                return discoverFrag;
            case 2:
                VideosFrag videosFrag= new VideosFrag();
                return videosFrag;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
