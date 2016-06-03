package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentStartActivityForResult extends AppCompatActivity {

    //    private static final String LOG_TAG = FragmentStartActivityForResult.class.getSimpleName();
    private static final String LOG_TAG = "Activity";
    private static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreate(): " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_start_activity_for_result);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.add_fragment)
    void addFragment() {
        Fragment fragmentByTag = getFragmentManager().findFragmentByTag(FragmentG.TAG);
        if (fragmentByTag == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, FragmentG.createInstance("parent", 12), FragmentG.TAG).commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(LOG_TAG, "onActivityResult: requestCode: " + requestCode + ", resultCode: " + resultCode + ", data: " + data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(LOG_TAG, "onStart()");
        super.onStart();
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        Log.d(LOG_TAG, "onStateNotSaved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onRestoreInstanceState(): " + savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i(LOG_TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState(): " + outState);
    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, "onDestroy()");
        super.onDestroy();
    }
}
