package com.example.rumahkite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rumahkite.adapter.TabAdapter;
import com.example.rumahkite.fragment.TabListFragment;
import com.example.rumahkite.fragment.TabMapsFragment;
import com.google.android.material.tabs.TabLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TabsActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        viewPager = findViewById(R.id.tabViewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabMapsFragment(), "Tampilan Maps");
        adapter.addFragment(new TabListFragment(), "Tampilan List");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setCustomFont();
    }

    public void setCustomFont() {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getAssets(), "font/TitilliumWeb-Bold.ttf"));
                }
            }
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
