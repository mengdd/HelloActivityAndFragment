package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NestedFragmentsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_fragments_activity_layout);
        ButterKnife.bind(this);
        showFragment(new FragmentC(), "C");
    }

    private void showFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    @OnClick(R.id.add_second)
    void addAnotherFragment() {
        showFragment(new FragmentD(), "D");
    }
}
