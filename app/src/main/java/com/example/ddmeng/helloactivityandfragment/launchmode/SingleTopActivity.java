package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        TaskUtils.getCurrentTopActivityName(this);
        // top activity: this SingleTopActivity


        Button startSingleTopButton = (Button) findViewById(R.id.launch_mode_start_single_top_button);
        startSingleTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SingleTopActivity.this, SingleTopActivity.class);
                startActivity(intent);

                //The singleTop launch mode: when the activity has instance on the top of stack of target task, reuse it.
                //otherwise, it's the same as the standard launch mode.
                //reuse it means, the onNewIntent() will be called to handle the new intent

            }
        });
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
        TaskUtils.getCurrentTopActivityName(this);
        //the top activity we got is still singleTop activity here
    }
}
