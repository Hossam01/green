package com.example.el3afreet.green.NewFragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Temperature extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(com.example.el3afreet.green.R.layout.fixtures_new_tabs,container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(com.example.el3afreet.green.R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(com.example.el3afreet.green.R.id.result_tabs);
        tabs.setupWithViewPager(viewPager);


        return view;

    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        FixturesTabs.Adapter adapter = new FixturesTabs.Adapter(getChildFragmentManager());

        adapter.addFragment(new TemperatureFragment(), "Temperature");
        adapter.addFragment(new History(), "History");

        viewPager.setAdapter(adapter);



    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
