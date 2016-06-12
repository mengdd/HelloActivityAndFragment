package com.example.ddmeng.helloactivityandfragment.state;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.activity.BasicActivityA;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StateRestoreDemoActivity extends AppCompatActivity {

    public static final String TAG = StateRestoreDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate() " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_restore_demo);
        ButterKnife.bind(this);
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState(): " + savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState(): " + outState);
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop()");
        super.onStop();
    }

    @OnClick(R.id.button_open_another_activity)
    void onOpenAnotherActivity() {
        startActivity(new Intent(this, BasicActivityA.class));
    }
}
