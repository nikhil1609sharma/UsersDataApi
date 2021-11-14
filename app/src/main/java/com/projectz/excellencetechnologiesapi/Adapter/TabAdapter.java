package com.projectz.excellencetechnologiesapi.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.projectz.excellencetechnologiesapi.Fragment.Page_One;
import com.projectz.excellencetechnologiesapi.Fragment.Page_Two;

public class TabAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Page_One page_one = new Page_One();
                return page_one;
            case 1:
                Page_Two page_two = new Page_Two();
                return page_two;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
