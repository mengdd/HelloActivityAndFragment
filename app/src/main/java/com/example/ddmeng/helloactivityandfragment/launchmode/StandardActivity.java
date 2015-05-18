package com.example.ddmeng.helloactivityandfragment.launchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ddmeng.helloactivityandfragment.R;

public class StandardActivity extends Activity {
    private static final String LOG_TAG = "Launch Mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_mode_standard_activity);
        Button startSingleTopButton = (Button) findViewById(R.id.launch_mode_start_single_top_button);
        startSingleTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "start single top button click");

                Intent intent = new Intent();
                intent.setClass(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent);
                //start twice
                startActivity(intent);
            }
        });
    }
}
