package com.example.ddmeng.helloactivityandfragment.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentWithParameters extends Fragment {
    public static final String TAG = FragmentWithParameters.class.getSimpleName();
    public static final String NUM = "num";
    private int num;

    @BindView(R.id.num_text)
    TextView numText;

    public static FragmentWithParameters newInstance(int num) {
        FragmentWithParameters fragmentWithParameter = new FragmentWithParameters();
        Bundle args = new Bundle();
        args.putInt(NUM, num);
        fragmentWithParameter.setArguments(args);
        return fragmentWithParameter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        num = getArguments() != null ? getArguments().getInt(NUM) : 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_parameters, container, false);
        ButterKnife.bind(this, view);
        numText.setText("Number is: " + num);
        return view;
    }
}
