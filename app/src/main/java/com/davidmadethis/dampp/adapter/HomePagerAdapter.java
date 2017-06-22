package com.davidmadethis.dampp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.davidmadethis.dampp.fragment.HomeFragment;
import com.davidmadethis.dampp.fragment.NotificationFragment;
import com.davidmadethis.dampp.fragment.ProfileFragment;


/**
 * Created by root on 2/12/17.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {


    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new HomeFragment();
            case 0:
                return new NotificationFragment();

            case 2:
                return new ProfileFragment();
            default:
                break;
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
