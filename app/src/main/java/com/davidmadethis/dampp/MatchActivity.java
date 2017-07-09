package com.davidmadethis.dampp;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.davidmadethis.dampp.fragment.MatchFragment;
import com.squareup.seismic.ShakeDetector;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MatchActivity extends AppCompatActivity implements ShakeDetector.Listener{

    @Bind(R.id.fragment_container)
    FrameLayout fragment_container;

    boolean isFirstStart=false;//to avoid overlapping

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);

        MatchFragment matchFragment =MatchFragment.newInstance();
        makeFullScreen();

        ShakeDetector shakeDetector=new ShakeDetector(this);
        SensorManager sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        shakeDetector.start(sensorManager);

        if(isFirstStart){
            //to avoid overlapping of fragments' views
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, matchFragment).commit();
        }else {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, matchFragment).commit();
        }
        isFirstStart=true;
    }


    private void makeFullScreen() {

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        fragment_container.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void nextPic() {
        MatchFragment matchFragment=MatchFragment.newInstance();
        //to avoid overlapping of fragments' views
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, matchFragment).commit();
    }

    @Override
    public void hearShake() {
        nextPic();
        Toast.makeText(MatchActivity.this, "not matched", Toast.LENGTH_SHORT).show();
    }
}
