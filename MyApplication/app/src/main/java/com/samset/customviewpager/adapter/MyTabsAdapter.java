package com.samset.customviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.samset.customviewpager.SimpleFragment;

/**
 * Created by Karan singh on 20/01/16.
 */
public class MyTabsAdapter extends FragmentPagerAdapter {
    public MyTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i) {
            case 0: return SimpleFragment.getInstance();
            case 1: return SimpleFragment.getInstance();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0: return "Tab 1";
            case 1: return "Tab 2";
        }
        return "";
    }
}