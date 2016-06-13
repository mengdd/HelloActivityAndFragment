package com.example.ddmeng.helloactivityandfragment.state;

import android.app.Fragment;
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

    // 如果我们保存了Fragment的引用, 并且只new一次, tab2的状态是会自动保存并恢复的
    // tab1中的状态没有恢复是因为View没有id
    private Fragment tab1Fragment;
    private Fragment tab2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate() " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_restore_demo);
        ButterKnife.bind(this);

        initFragments();
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
        Log.e(TAG, "onRestoreInstanceState(): " + savedInstanceState);
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
        Log.e(TAG, "onSaveInstanceState(): " + outState);
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

    @OnClick(R.id.tab1)
    void onTab1Clicked() {
        getFragmentManager().beginTransaction()
                .replace(R.id.content_container, tab1Fragment, Tab1Fragment.TAG)
                .commit();
    }

    @OnClick(R.id.tab2)
    void onTab2Clicked() {
        getFragmentManager().beginTransaction()
                .replace(R.id.content_container, tab2Fragment, Tab2Fragment.TAG)
                .commit();

    }

    private void initFragments() {
        tab1Fragment = getFragmentManager().findFragmentByTag(Tab1Fragment.TAG);
        if (tab1Fragment == null) {
            tab1Fragment = new Tab1Fragment();
        }
        tab2Fragment = getFragmentManager().findFragmentByTag(Tab2Fragment.TAG);
        if (tab2Fragment == null) {
            tab2Fragment = new Tab2Fragment();
        }
    }
}
