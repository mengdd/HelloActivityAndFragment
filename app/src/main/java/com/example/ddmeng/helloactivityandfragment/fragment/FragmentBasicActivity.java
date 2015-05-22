package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;

public class FragmentBasicActivity extends Activity {
    private static final String LOG_TAG = FragmentBasicActivity.class.getSimpleName();
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_basic_activity_layout);
        ButterKnife.inject(this);
    }

    @OnCheckedChanged(R.id.fragment_b_control_toggle)
    void toggleFragmentB(CompoundButton toggleButton, boolean checked) {
        Log.d(LOG_TAG, "toggle " + checked);
        if (checked) {
            addFragmentB();
        } else {
            removeFragmentB();
        }

    }

    private void addFragmentB() {
        //You can also add/remove fragment dynamically
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.fragment_container, fragmentB);
        fragmentTransaction.commit();
    }

    private void removeFragmentB() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragmentB);
        fragmentTransaction.commit();
    }


    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onDestroy()");
        super.onDestroy();
    }
}
