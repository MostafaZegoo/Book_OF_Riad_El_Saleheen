package com.mostafa.book_of_riad_el_saleheen.ui;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    ViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragmentList = fragments;
    }

    // Returns the fragment to display for a particular page.
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    // Returns total number of pages.
    @Override
    public int getCount() {
        return this.fragmentList.size();
    }
}
