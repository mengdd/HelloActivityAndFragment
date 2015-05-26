package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.utils.TaskUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class StandardActivity extends Activity {
    private static final String LOG_TAG = "Launch Mode";
    @InjectView(R.id.launch_mode_update_stack_info)
    Button mStackInfo = null;

    @InjectView(R.id.current_task)
    TextView mTaskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "Standard Activity onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_mode_standard_activity);
        ButterKnife.inject(this);
        Log.i(LOG_TAG, "task id: " + this.getTaskId());
        mTaskText.setText("Currrent Task: " + this.getTaskId());
    }

    @OnClick(R.id.launch_mode_start_single_top_button)
    void startSingleTopActivity() {
        Log.i(LOG_TAG, "start single top button click");

        Intent intent = new Intent();
        intent.setClass(StandardActivity.this, SingleTopActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_mode_start_single_task_button)
    void startSingleTaskActivity() {
        Log.i(LOG_TAG, "start single task button click");

        Intent intent = new Intent();
        intent.setClass(StandardActivity.this, SingleTaskActivity.class);
        startActivity(intent);
        // If the singleTask want to be in a different task, taskAffinity should be specified.
        // every time start a new singleTask activity from here, new task id++
    }

    @OnClick(R.id.launch_mode_update_stack_info)
    void updateStackInfoButtonClick() {
        updateStackInfo();
    }

    private void updateStackInfo() {
        String currentTopActivityName = TaskUtils.getCurrentTopActivityName(this);
        CharSequence info = getResources().getString(R.string.launch_mode_stack_info) + ", top Activity: " + currentTopActivityName;
        mStackInfo.setText(info);
    }

    @Override
    protected void onRestart() {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onReStart()");
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
}
