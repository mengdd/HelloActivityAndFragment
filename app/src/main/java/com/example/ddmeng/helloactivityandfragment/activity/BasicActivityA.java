package com.example.ddmeng.helloactivityandfragment.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.ddmeng.helloactivityandfragment.R;

public class BasicActivityA extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.basic_activity_a);
    }
}
