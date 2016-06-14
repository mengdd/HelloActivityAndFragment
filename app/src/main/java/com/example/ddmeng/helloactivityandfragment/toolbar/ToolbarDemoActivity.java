package com.example.ddmeng.helloactivityandfragment.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToolbarDemoActivity extends AppCompatActivity {
    public static final String TAG = ToolbarDemoActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_demo);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // add a left arrow to back to parent activity,
        // no need to handle action selected event, this is handled by super
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e(TAG, "onCreateOptionsMenu()");
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_android:
                Log.i(TAG, "action android selected");
                return true;
            case R.id.action_favourite:
                Log.i(TAG, "action favourite selected");
                return true;
            case R.id.action_settings:
                Log.i(TAG, "action settings selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.button_show_fragment)
    void showFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new ToolbarFragment(), ToolbarFragment.TAG)
                .addToBackStack(ToolbarFragment.TAG)
                .commit();
        // android.R.id.content get the root view for the current activity
    }
}
