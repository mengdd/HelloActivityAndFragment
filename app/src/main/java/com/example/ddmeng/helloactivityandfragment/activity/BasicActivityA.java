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
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity_a);

        ButterKnife.bind(this);
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
