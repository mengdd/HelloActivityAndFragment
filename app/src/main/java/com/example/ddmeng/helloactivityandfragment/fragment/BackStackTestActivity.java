package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BackStackTestActivity extends Activity {
    private static final String LOG_TAG = "BackStack";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_back_stack_activity_layout);
        ButterKnife.bind(this);
    }

    private int count = 1;

    @OnClick(R.id.add_fragment_button)
    void onAddFragmentClicked() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentH fragment = FragmentH.createInstance("" + count++);
        Log.i(LOG_TAG, "do add fragment");
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, FragmentB.TAG)
                .addToBackStack(null)
                .commit();

    }

    @OnClick(R.id.replace_fragment_button)
    void onReplaceFragmentClicked() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentH fragment = FragmentH.createInstance("final");
        Log.i(LOG_TAG, "replace fragment");

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, FragmentB.TAG)
                .commit();

    }
}
