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

public class FragmentReplacementActivity extends Activity {
    private static final String LOG_TAG = FragmentReplacementActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_replace_activity_layout);
        ButterKnife.bind(this);
    }

    @OnCheckedChanged(R.id.fragment_b_control_toggle)
    void toggleFragmentB(CompoundButton toggleButton, boolean checked) {
        Log.d(LOG_TAG, "toggle " + checked);
        //this will have bug when "Do no keep activities" turned on
        //because, when the FragmentB is shown, home exit and enter again, the system auto recover the fragment
        //the checked status is also recovered, this method will invoke once, with the checked is true
        //So, the fragmentB is added twice, and remove button can only remove one of them
        if (checked) {
            replaceFragmentAWithB();
        } else {
            removeFragmentB();
        }

    }

    private void replaceFragmentAWithB() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(FragmentB.TAG);
        if (null == fragment) {
            FragmentB fragmentB = new FragmentB();
            Log.i(LOG_TAG, "do add fragmentB action");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.replace_container, fragmentB, FragmentB.TAG)
                    .addToBackStack(FragmentB.TAG)
                    .commit();

            // if we replace() without addToBackStack(), FragmentA will destroyed and detach.
            // But then remove FragmentB, A's view is still shown, although A is destroyed.

            // if we replace() with addToBackStack(), FragmentA will go till onDestroyView()
            // when back pressed, FragmentB will be detached, and A will resume.
        }
    }

    private void removeFragmentB() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(FragmentB.TAG);
        if (null != fragment) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment).commit();
        }
        //remove() only goes down to onDestroyView(), not onDestroy() and onDetach()
        //if addToBackStack(), back button will goes down to onDetach()
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
