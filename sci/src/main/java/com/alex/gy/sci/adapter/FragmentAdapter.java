package com.alex.gy.sci.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alex.gy.sci.view.DiscoveryFragment;
import com.alex.gy.sci.view.IndexFragment;
import com.alex.gy.sci.view.QuestionFragment;
import com.alex.gy.sci.view.SignFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * just for ViewPager
 * Created by gy on 2016/8/13.
 */
public class FragmentAdapter extends FragmentPagerAdapter {


    private List<Fragment> listViews = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        IndexFragment tab1 = new IndexFragment();
        DiscoveryFragment tab2 = new DiscoveryFragment();
        QuestionFragment tab3 = new QuestionFragment();
        SignFragment tab4 = new SignFragment();
        listViews.add(tab1);
        listViews.add(tab2);
        listViews.add(tab3);
        listViews.add(tab4);
    }

    @Override
    public Fragment getItem(int position) {
        return listViews.get(position);
    }

    @Override
    public int getCount() {
        return listViews.size();
    }
}
