package com.example.ddmeng.helloactivityandfragment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ddmeng.helloactivityandfragment.R;

public class BasicActivityB extends Activity {
    private static final String LOG_TAG = "Basic Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "Activity B ===" + " onCreate()");
        setContentView(R.layout.basic_activity_b);

        Button turnToAButton = (Button) findViewById(R.id.basic_turn_to_a_button);
        turnToAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this codes will start a new BasicActivityA, so the stack will be A->B->A, and this mode can repeat again and again
                Intent intent = new Intent();
                intent.setClass(BasicActivityB.this, BasicActivityA.class);
                startActivity(intent);
            }
        });

        Button finishButton = (Button) findViewById(R.id.basic_finish_b_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG, "Activity B ===" + " onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "Activity B ===" + " onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "Activity B ===" + " onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "Activity B ===" + " onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "Activity B ===" + " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "Activity B ===" + " onDestroy()");
    }
}
