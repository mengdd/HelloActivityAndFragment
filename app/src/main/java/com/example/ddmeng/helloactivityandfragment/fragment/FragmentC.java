package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ddmeng.helloactivityandfragment.R;

public class FragmentC extends Fragment {
    private static final String LOG_TAG = FragmentC.class.getSimpleName();
    private static final String NESTED_FRAGMENT_TAG = FragmentA.class.getSimpleName();

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

        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

        Fragment fragmentA = getChildFragmentManager().findFragmentByTag(NESTED_FRAGMENT_TAG);
        if (fragmentA == null) {
            Log.i(LOG_TAG, "add new FragmentA !!");
            fragmentA = new FragmentA();
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragmentA, NESTED_FRAGMENT_TAG).commit();
        } else {
            Log.i(LOG_TAG, "found existing FragmentA, no need to add it again !!");
        }
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
        // Not working, getFragments() return null
//        List<Fragment> fragments = getChildFragmentManager().getFragments();
//        if (fragments != null) {
//            for (Fragment f : fragments) {
//                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//                ft.remove(f).commitAllowingStateLoss();
//            }
//        }

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
