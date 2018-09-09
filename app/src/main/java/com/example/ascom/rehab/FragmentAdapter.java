package com.example.ascom.rehab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ascom.rehab.fragments.AppointmentsFragment;
import com.example.ascom.rehab.fragments.BookDoctorFragment;
import com.example.ascom.rehab.fragments.FavouritFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    Context context ;

    public FragmentAdapter(FragmentManager fm , Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BookDoctorFragment();
            case 1:
                return new FavouritFragment();
            case 2:
                return new AppointmentsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            //
            //Your tab titles
            //
            case 0:return context.getResources().getString(R.string.orderDoctor);
            case 1:return context.getResources().getString(R.string.favourite);
            case 2: return context.getResources().getString(R.string.appointments);
            default:return null;
        }
    }


}
