package com.example.ascom.rehab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ascom.rehab.fragments.MyProfileFragment;
import com.example.ascom.rehab.fragments.MyTimesFragment;
import com.example.ascom.rehab.fragments.MyTimesWorkFragment;

public class Fragment2Adapter extends FragmentPagerAdapter {
    Context context;

    public Fragment2Adapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return  new MyProfileFragment();
            case 1:
                return  new MyTimesWorkFragment();
            case  2 :
                return  new MyTimesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return context.getResources().getString(R.string.MyProfile);
            case 1 : return context.getResources().getString(R.string.MyTimesWork);
            case 2 : return context.getResources().getString(R.string.MyTimes);
            default: return  null;

        }
    }
}
