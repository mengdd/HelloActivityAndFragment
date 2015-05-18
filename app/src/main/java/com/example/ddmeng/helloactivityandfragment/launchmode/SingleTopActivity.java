package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.utils.TaskUtils;

public class SingleTopActivity extends Activity {

    private static final String LOG_TAG = "Launch Mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_mode_single_top_activity);

        Log.i(LOG_TAG, "Single Top Activity, onCreate(), " + this.hashCode());

        //strange phenomenon:
        // When start this activity, startActivity() is called twice deliberately
        // then the onCreate() is called once (right).
        // But when press back, the onCreate() is called again (strange)
        // So using normal eyes, the singleTop activity appear two times.

        //Conclusions: Do NOT call startActivity() twice
        // Because before onCreate() invoked, the singleTop activity are still not considered as on the top of the stack
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(LOG_TAG, "Single Top Activity, onNewIntent(), " + this.hashCode());
        //strange: this log is never shown
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "Single Top Activity, onResume(), " + this.hashCode());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "Single Top Activity, onPause(), " + this.hashCode());

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "Single Top Activity, onStop(), " + this.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "Single Top Activity, onDestroy(), " + this.hashCode());
    }
}
