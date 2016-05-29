package com.example.ddmeng.helloactivityandfragment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicActivityB extends Activity {
    private static final String LOG_TAG = "Basic Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "Activity B ===" + " onCreate() " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity_b);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.basic_turn_to_a_button)
    void turnToAActivity() {
        //this codes will start a new BasicActivityA, so the stack will be A->B->A, and this mode can repeat again and again
        Intent intent = new Intent();
        intent.setClass(BasicActivityB.this, BasicActivityA.class);
        startActivity(intent);
    }

    @OnClick(R.id.basic_finish_b_button)
    void finishB() {
        finish();
    }

    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, "Activity B ===" + " onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(LOG_TAG, "Activity B ===" + " onStart()");
        super.onStart();
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        Log.d(LOG_TAG, this.getClass().getSimpleName() + " onStateNotSaved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(LOG_TAG, this.getClass().getSimpleName() + " onRestoreInstanceState(): " + savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i(LOG_TAG, "Activity B ===" + " onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, "Activity B ===" + " onPause()");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, this.getClass().getSimpleName() + " onSaveInstanceState(): " + outState);
    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, "Activity B ===" + " onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, "Activity B ===" + " onDestroy()");
        super.onDestroy();
    }
}
