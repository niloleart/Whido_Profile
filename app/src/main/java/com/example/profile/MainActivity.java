package com.example.profile;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding Toolbar to Main screen
        /** Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         */
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        //tabs.setTabTextColors(R.color.primaryText, R.color.colorAccent);
        tabs.setupWithViewPager(viewPager);
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new PastEventsFragment(), "Past Events");
        adapter.addFragment(new MainProfileFragment(), "Profile");
        adapter.addFragment(new FutureEventsFragment(), "Future Events");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mPastEvents = new ArrayList<>();
        private final List<Fragment> mFutureEvents = new ArrayList<>();
        private String[] tabTitles = new String[]{"Past Events", "Profile", "Future Events"};

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mPastEvents.get(position);
        }

        @Override
        public int getCount() {
            return mPastEvents.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mPastEvents.add(fragment);
            mFutureEvents.add(fragment);
        }
    }
}
