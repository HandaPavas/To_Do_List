package com.example.root.to_do_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by root on 11/5/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

  //  List<Title> data = Collections.emptyList();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment= new DetailsFragment();
        Bundle bundle= new Bundle();
        bundle.putInt("count",position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.data.size();
    }
}
