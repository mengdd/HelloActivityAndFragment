package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentWithParametersActivity extends AppCompatActivity {

    @BindView(R.id.input)
    EditText inputText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_with_parameters_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.submit)
    void onSubmitClicked() {
        String input = inputText.getText().toString();
        Integer num = 0;
        try {
            num = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        FragmentWithParameters fragment = FragmentWithParameters.newInstance(num);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.container, fragment, FragmentWithParameters.TAG)//every submit will add one fragment instance
                .addToBackStack(FragmentWithParameters.TAG) // if we add to back stack, every back pop out one fragment
                .commit();
    }
}
