package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleInstanceActivity extends AppCompatActivity {
    private static final String LOG_TAG = SingleInstanceActivity.class.getSimpleName();
    @BindView(R.id.current_task)
    TextView mTaskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_mode_single_instance_activity);
        ButterKnife.bind(this);
        Log.i(LOG_TAG, "task id: " + this.getTaskId());
        mTaskText.setText("Currrent Task: " + this.getTaskId());
    }

    @OnClick(R.id.launch_mode_start_standard)
    void startStandardActivity() {
        Log.i(LOG_TAG, "start standard button click");

        Intent intent = new Intent();
        intent.setClass(SingleInstanceActivity.this, StandardActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_mode_start_single_top)
    void startSingleTopActivity() {
        Log.i(LOG_TAG, "start single top button click");

        Intent intent = new Intent();
        intent.setClass(SingleInstanceActivity.this, SingleTopActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.launch_mode_start_single_task)
    void startSingleTaskActivity() {
        Log.i(LOG_TAG, "start single task button click");

        Intent intent = new Intent();
        intent.setClass(SingleInstanceActivity.this, SingleTaskActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_mode_start_single_instance)
    void startSingleInstanceActivity() {
        Log.i(LOG_TAG, "start single instance button click");
        Intent intent = new Intent();
        intent.setClass(SingleInstanceActivity.this, SingleInstanceActivity.class);
        startActivity(intent);

        //click start single instance will invoke callbacks:
        //onPause(), onNewIntent(), onResume()
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onNewIntent()");
        super.onNewIntent(intent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_instance, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
