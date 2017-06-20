package com.davidmadethis.dampp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.orangegangsters.lollipin.lib.managers.AppLock;
import com.github.orangegangsters.lollipin.lib.managers.LockManager;

/**
 * Created by root on 6/11/17.
 */

public class FollowUpFragment extends Fragment {

    String TAG = this.getClass().getName();
    public FollowUpFragment(){}
    int REQUEST_CODE_ENABLE = 333;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_followup, container, false);




        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {
            LockManager<DamppPinActivity> lockManager = LockManager.getInstance();
            lockManager.getAppLock().setLogoId(R.drawable.ic_homeing);
            lockManager.getAppLock().setFingerprintAuthEnabled(false);
            lockManager.getAppLock().setPasscode("2323");
            lockManager.enableAppLock(getActivity(),DamppPinActivity.class);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getActivity().getApplicationContext(),"GOTEN",Toast.LENGTH_LONG)
                .show();

        Log.e(TAG,data.getDataString());
    }
}
