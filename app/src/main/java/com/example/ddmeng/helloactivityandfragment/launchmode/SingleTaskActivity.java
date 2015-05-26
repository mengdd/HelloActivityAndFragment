package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SingleTaskActivity extends AppCompatActivity {

    private static final String LOG_TAG = SingleTaskActivity.class.getSimpleName();
    @InjectView(R.id.current_task)
    TextView mTaskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, this.getClass().getSimpleName() + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_mode_single_task_activity);
        ButterKnife.inject(this);
        Log.i(LOG_TAG, "task id: " + this.getTaskId());
        mTaskText.setText("Currrent Task: " + this.getTaskId());

        //if taskAffinity attribute is not specified, the taskId is the same as the activity start it.
        // when set android:taskAffinity=".singleTask" in manifest activity, this activity will have a different task Id

    }

    @OnClick(R.id.launch_mode_start_standard)
    void startStandardActivity() {
        Log.i(LOG_TAG, "start standard button click");

        Intent intent = new Intent();
        intent.setClass(SingleTaskActivity.this, StandardActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_mode_start_single_top)
    void startSingleTopActivity() {
        Log.i(LOG_TAG, "start single top button click");

        Intent intent = new Intent();
        intent.setClass(SingleTaskActivity.this, SingleTopActivity.class);
        startActivity(intent);

        //start new standard or singleTop activity from singleTask, the new activities will be in the singleTask's task
    }

    @OnClick(R.id.launch_mode_start_single_task)
    void startSingleTaskActivity() {
        Log.i(LOG_TAG, "start single task button click");

        Intent intent = new Intent();
        intent.setClass(SingleTaskActivity.this, SingleTaskActivity.class);
        startActivity(intent);
        //this will not create a new instance of the activity, callbacks after the click event are:
        //onPause(), onNewIntent(), onResume()
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_task, menu);
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
}
