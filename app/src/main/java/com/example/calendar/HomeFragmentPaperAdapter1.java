package com.example.calendar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeFragmentPaperAdapter1 extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;
    private String[] titles = new String[]{"Dương lịch", "Âm lịch"};

    protected HomeFragmentPaperAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() { return PAGE_COUNT; }

    @Override
    public Fragment getItem(int page){
        switch (page){
            case 0:
                return CurrentTimeFragment.newInstance(0,"Solar");
            case 1:
                return CurrentWeatherFragment.newInstance(1,"Lunar");
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
