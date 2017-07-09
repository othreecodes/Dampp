package com.davidmadethis.dampp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.davidmadethis.dampp.custom.ScaleImageView;
import com.davidmadethis.dampp.ProfileActivity;
import com.davidmadethis.dampp.R;

import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {

    View rootView;
    boolean doubleClick=false;

    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //List of images
        int[] intArray=new int[]{R.drawable.bg_1, R.drawable.bg_2,R.drawable.background, R.drawable.girl};
        rootView=inflater.inflate(R.layout.fragment_match, container, false);
        ScaleImageView scaleImageView=(ScaleImageView)rootView.findViewById(R.id.scaleImageView);
        int rand=(new Random()).nextInt(intArray.length-1);

        //anti more than or less than index crosscheck; IndexException for array
        if(rand<0 || rand>(intArray.length-1)){
            rand=0;
        }

        scaleImageView.setImageResource(intArray[rand]);
        scaleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDbClickHandler();
                if(doubleClick){
                    Toast.makeText(getContext(), "matchsent", Toast.LENGTH_SHORT).show();
                }
                doubleClick=true;
            }
        });

        return rootView;
    }

    private void startDbClickHandler() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //sets doubleclick ==false after 500ms
                doubleClick=false;
            }
        }, 500);
    }

    public static MatchFragment newInstance() {
        MatchFragment matchFragment=new MatchFragment();
        Bundle args=new Bundle();
        matchFragment.setArguments(args);
        return matchFragment;
    }
}
