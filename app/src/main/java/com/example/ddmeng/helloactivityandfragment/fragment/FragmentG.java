package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.activity.StartForResultActivityTwo;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * This fragment is to test startActivityForResult() method inside fragment and nested fragment
 */
public class FragmentG extends Fragment {
    public static final String LOG_TAG = FragmentG.class.getSimpleName();
    private static final String NESTED_FRAGMENT_TAG = FragmentA.class.getSimpleName();
    private static final int REQUEST_CODE = 333;


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
        return inflater.inflate(R.layout.fragment_g, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

    }


    @OnClick(R.id.add_child_fragment)
    void addChildFragment() {

        Fragment fragmentA = getChildFragmentManager().findFragmentByTag(NESTED_FRAGMENT_TAG);
        if (fragmentA == null) {
            Log.i(LOG_TAG, "add new FragmentA !!");
            fragmentA = new FragmentA();
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_container, fragmentA, NESTED_FRAGMENT_TAG).commit();
        } else {
            Log.i(LOG_TAG, "found existing FragmentA, no need to add it again !!");
        }
    }

    @OnClick(R.id.start_activity_for_result)
    void turnToAnotherActivity() {

        startActivityForResult(new Intent(getActivity(), StartForResultActivityTwo.class), REQUEST_CODE);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // the Activity's onActivityResult() did not get invoked
        Log.e(LOG_TAG, "onActivityResult: requestCode: " + requestCode + ", resultCode: " + resultCode + ", data: " + data);
        super.onActivityResult(requestCode, resultCode, data);
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
