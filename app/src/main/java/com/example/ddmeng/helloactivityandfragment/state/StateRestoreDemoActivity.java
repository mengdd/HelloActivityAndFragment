package com.example.ddmeng.helloactivityandfragment.state;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.activity.BasicActivityA;

import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;
import icepick.State;

public class StateRestoreDemoActivity extends AppCompatActivity {

    public static final String TAG = StateRestoreDemoActivity.class.getSimpleName();

    @State
    SparseArray<Fragment.SavedState> savedStateSparseArray = new SparseArray<>();

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

        Icepick.restoreInstanceState(this, savedInstanceState);
//        initFragments();
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
        Icepick.saveInstanceState(this, outState);
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
        // save current tab
        Fragment tab2Fragment = getSupportFragmentManager().findFragmentByTag(Tab2Fragment.TAG);
        if (tab2Fragment != null) {
            saveFragmentState(1, tab2Fragment);
        }

        // restore last state
        Tab1Fragment tab1Fragment = new Tab1Fragment();
        restoreFragmentState(0, tab1Fragment);

        // show new tab
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, tab1Fragment, Tab1Fragment.TAG)
                .commit();
    }

    @OnClick(R.id.tab2)
    void onTab2Clicked() {
        Fragment tab1Fragment = getSupportFragmentManager().findFragmentByTag(Tab1Fragment.TAG);
        if (tab1Fragment != null) {
            saveFragmentState(0, tab1Fragment);
        }

        Tab2Fragment tab2Fragment = new Tab2Fragment();
        restoreFragmentState(1, tab2Fragment);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, tab2Fragment, Tab2Fragment.TAG)
                .commit();
        // 如果我们每次都传入新的实例, 则上一个实例的状态是无法传到新的实例的
        // 所以我们需要手动保存和恢复

    }

    private void saveFragmentState(int index, Fragment fragment) {
        Fragment.SavedState savedState = getSupportFragmentManager().saveFragmentInstanceState(fragment);
        savedStateSparseArray.put(index, savedState);
    }

    private void restoreFragmentState(int index, Fragment fragment) {
        Fragment.SavedState savedState = savedStateSparseArray.get(index);
        fragment.setInitialSavedState(savedState);
    }

    private void initFragments() {
        tab1Fragment = getSupportFragmentManager().findFragmentByTag(Tab1Fragment.TAG);
        if (tab1Fragment == null) {
            tab1Fragment = new Tab1Fragment();
        }
        tab2Fragment = getSupportFragmentManager().findFragmentByTag(Tab2Fragment.TAG);
        if (tab2Fragment == null) {
            tab2Fragment = new Tab2Fragment();
        }
    }
}
