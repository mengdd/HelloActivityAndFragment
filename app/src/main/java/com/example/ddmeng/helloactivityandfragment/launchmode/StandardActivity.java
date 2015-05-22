package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.ddmeng.helloactivityandfragment.R;
import com.example.ddmeng.helloactivityandfragment.utils.TaskUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class StandardActivity extends Activity {
    private static final String LOG_TAG = "Launch Mode";
    @InjectView(R.id.launch_mode_update_stack_info)
    Button mStackInfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "Standard Activity onCreate()");
        setContentView(R.layout.launch_mode_standard_activity);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.launch_mode_start_single_top_button)
    void startSingleTopActivity() {
        Log.i(LOG_TAG, "start single top button click");

        Intent intent = new Intent();
        intent.setClass(StandardActivity.this, SingleTopActivity.class);
        startActivity(intent);
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
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onDestroy()");
    }
}
