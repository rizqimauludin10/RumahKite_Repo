package com.example.rumahkite.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> tittlefragmentList = new ArrayList<>();

    public TabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        tittlefragmentList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tittlefragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
