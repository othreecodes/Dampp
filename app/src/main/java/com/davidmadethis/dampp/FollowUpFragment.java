package com.davidmadethis.dampp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;


/**
 * Created by root on 6/11/17.
 */

public class FollowUpFragment extends Fragment {

    String TAG = this.getClass().getName();
    public FollowUpFragment(){}

    PinLockView mPinLockView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_followup, container, false);

        mPinLockView = (PinLockView) v.findViewById(R.id.pin_lock_view);
        mPinLockView.setPinLockListener(mPinLockListener);

        return v;
    }

    private PinLockListener mPinLockListener = new PinLockListener() {
        @Override
        public void onComplete(String pin) {
            Log.d(TAG, "Pin complete: " + pin);
        }

        @Override
        public void onEmpty() {
            Log.d(TAG, "Pin empty");
        }

        @Override
        public void onPinChange(int pinLength, String intermediatePin) {
            Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
        }
    };
}
