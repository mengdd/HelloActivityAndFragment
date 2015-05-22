package com.example.ddmeng.helloactivityandfragment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicActivityA extends Activity {
    private static final String LOG_TAG = "Basic Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        setContentView(R.layout.basic_activity_a);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.basic_turn_to_b_button)
    void turnToBActivity() {
        Intent intent = new Intent();
        intent.setClass(BasicActivityA.this, BasicActivityB.class);
        startActivity(intent);
    }

    @OnClick(R.id.basic_finish_a_button)
    void finishA() {
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onDestroy()");
    }
}
