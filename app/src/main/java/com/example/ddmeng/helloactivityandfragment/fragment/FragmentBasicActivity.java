package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class FragmentBasicActivity extends Activity {
    private static final String LOG_TAG = FragmentBasicActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_basic_activity_layout);
        ButterKnife.inject(this);
    }

    @OnCheckedChanged(R.id.fragment_b_control_toggle)
    void toggleFragmentB(CompoundButton toggleButton, boolean checked) {
        Log.d(LOG_TAG, "toggle " + checked);
        //this will have bug when "Do no keep activities" turned on
        //because, when the FragmentB is shown, home exit and enter again, the system auto recover the fragment
        //the checked status is also recovered, this method will invoke once, with the checked is true
        //So, the fragmentB is added twice, and remove button can only remove one of them
        if (checked) {
            addFragmentB();
        } else {
            removeFragmentB();
        }

    }

    private void addFragmentB() {
        //You can also add/remove fragment dynamically

        //FragmentTransactions are committed asynchronously
        //So getFragmentManager().executePendingTransactions(); must be called before isAdded()
        //That way, you can make sure that everything is up to date
        //http://stackoverflow.com/questions/22485899/fragment-isadded-returns-false-on-an-already-added-fragment


        //because if fragmentB's new instance is created in Activity's onCreate(), so the isAdded() method is always false for the new instance

        //I tried to use isAdded() method to solve the Do not keep activities bug, found not work, above are reasons.

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(FragmentB.TAG);
        if (null == fragment) {
            FragmentB fragmentB = new FragmentB();
            Log.i(LOG_TAG, "do add fragmentB action");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragmentB, FragmentB.TAG);
            fragmentTransaction.commit();
        }
    }

    private void removeFragmentB() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(FragmentB.TAG);
        if (null != fragment) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onSaveInstanceState() bundle: " + outState.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onRestoreInstanceState bundle: " + savedInstanceState.toString());
        super.onRestoreInstanceState(savedInstanceState);
    }
}
