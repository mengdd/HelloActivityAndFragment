package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ddmeng.helloactivityandfragment.R;

public class FragmentE extends Fragment {
    private static final String LOG_TAG = FragmentE.class.getSimpleName();

    @Override
    public void onAttach(Activity activity) {
        Log.i(LOG_TAG, "onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreateView()");
//        View inflate = null;
//        try {
//            inflate = inflater.inflate(R.layout.fragment_e, container, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//            /*
//            at com.example.ddmeng.helloactivityandfragment.fragment.FragmentE.onCreateView(FragmentE.java:35)
//            at android.app.Fragment.performCreateView(Fragment.java:2220)
//            at android.app.FragmentManagerImpl.moveToState(FragmentManager.java:973)
//            at android.app.FragmentManagerImpl.moveToState(FragmentManager.java:1148)
//            at android.app.FragmentManagerImpl.popBackStackState(FragmentManager.java:1587)
//            at android.app.FragmentManagerImpl.popBackStackImmediate(FragmentManager.java:578)
//            at android.support.v4.app.BaseFragmentActivityEclair.onBackPressedNotHandled(BaseFragmentActivityEclair.java:27)
//            at android.support.v4.app.FragmentActivity.onBackPressed(FragmentActivity.java:189)
//            Caused by: java.lang.IllegalArgumentException: Binary XML file line #16: Duplicate id 0x7f0c0059, tag null, or parent id 0xffffffff with another fragment for com.example.ddmeng.helloactivityandfragment.fragment.FragmentA
//            at android.app.FragmentManagerImpl.onCreateView(FragmentManager.java:2205)
//            */
//        }
//        return inflate;

        return inflater.inflate(R.layout.fragment_e, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(LOG_TAG, "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(LOG_TAG, "onResume()  --> Fragment is active");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(LOG_TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(LOG_TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(LOG_TAG, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(LOG_TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(LOG_TAG, "onDetach()");
        super.onDetach();
    }
}
