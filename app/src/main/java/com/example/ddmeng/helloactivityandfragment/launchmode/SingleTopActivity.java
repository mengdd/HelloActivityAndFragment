package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.utils.TaskUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SingleTopActivity extends Activity {

    private static final String LOG_TAG = "Launch Mode";
    @InjectView(R.id.current_task)
    TextView mTaskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.launch_mode_single_top_activity);
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);

        Log.i(LOG_TAG, "Single Top Activity, onCreate(), " + this.hashCode());
        Log.i(LOG_TAG, "task id: " + this.getTaskId());
        mTaskText.setText("Currrent Task: " + this.getTaskId());

        //strange phenomenon:
        // When start this activity, startActivity() is called twice deliberately
        // then the onCreate() is called once (right).
        // But when press back, the onCreate() is called again (strange)
        // So using normal eyes, the singleTop activity appear two times.

        //Conclusions: Do NOT call startActivity() twice
        // Because before onCreate() invoked, the singleTop activity are still not considered as on the top of the stack

        TaskUtils.getCurrentTopActivityName(this);
        // top activity: this SingleTopActivity

    }

    @OnClick(R.id.launch_mode_start_single_top_button)
    void startSingleTopActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(SingleTopActivity.this, SingleTopActivity.class);
        startActivity(intent);
        //The singleTop launch mode: when the activity has instance on the top of stack of target task, reuse it.
        //otherwise, it's the same as the standard launch mode.
        //reuse it means, the onNewIntent() will be called to handle the new intent

    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i(LOG_TAG, "Single Top Activity, onNewIntent(), " + this.hashCode());
        super.onNewIntent(intent);
        //strange: this log is never shown
    }

    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, "Single Top Activity, onRestart(), " + this.hashCode());
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(LOG_TAG, "Single Top Activity, onStart(), " + this.hashCode());
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(LOG_TAG, "Single Top Activity, onResume(), " + this.hashCode());
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, "Single Top Activity, onPause(), " + this.hashCode());
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, "Single Top Activity, onStop(), " + this.hashCode());
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, "Single Top Activity, onDestroy(), " + this.hashCode());
        super.onDestroy();
        TaskUtils.getCurrentTopActivityName(this);
        //the top activity we got is still singleTop activity here
    }
}
