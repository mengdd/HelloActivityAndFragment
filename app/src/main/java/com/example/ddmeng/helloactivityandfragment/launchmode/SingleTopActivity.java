package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;

public class SingleTopActivity extends Activity {

    private static final String LOG_TAG = "Launch Mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_mode_single_top_activity);

        Log.i(LOG_TAG, "Single Top Activity, onCreate()");

        //strange phenomenon:
        // When start this activity, startActivity() is called twice deliberately
        // then the onCreate() is called once (right).
        // But when press back, the onCreate() is called again (strange)
        // So using normal eyes, the singleTop activity appear two times.
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(LOG_TAG, "Single Top Activity, onNewIntent()");
        //strange: this log is never shown
    }
}
