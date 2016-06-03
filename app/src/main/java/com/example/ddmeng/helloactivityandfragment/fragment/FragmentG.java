package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
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
    public static final String TAG = FragmentG.class.getSimpleName();
    private String LOG_TAG = FragmentG.class.getSimpleName();
    private static final String KEY_NAME = "name";
    private static final String KEY_REQUEST_CODE = "request_code";

    private String name;
    private int requestCode;

    public static FragmentG createInstance(String name, int requestCode) {
        FragmentG fragmentG = new FragmentG();
        Bundle args = new Bundle();
        args.putString(KEY_NAME, name);
        args.putInt(KEY_REQUEST_CODE, requestCode);
        fragmentG.setArguments(args);
        return fragmentG;
    }


    @Override
    public void onAttach(Activity activity) {
        Log.i(LOG_TAG, "onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        name = arguments.getString(KEY_NAME);
        requestCode = arguments.getInt(KEY_REQUEST_CODE);
        LOG_TAG = LOG_TAG + ": " + name;
        Log.i(LOG_TAG, "onCreate()");
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
        Fragment fragmentByTag = getChildFragmentManager().findFragmentByTag(FragmentG.TAG);
        if (fragmentByTag == null) {
            getChildFragmentManager().beginTransaction()
                    .add(R.id.container, FragmentG.createInstance("child", 34), FragmentG.TAG).commit();
        }
    }

    @OnClick(R.id.start_activity_for_result)
    void turnToAnotherActivity() {

        startActivityForResult(new Intent(getActivity(), StartForResultActivityTwo.class), requestCode);
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
