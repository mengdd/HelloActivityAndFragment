package com.example.ddmeng.helloactivityandfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * This fragment add its child into a dynamic layout container
 * Which is often lead to crash when reconstructing view but the layout container is not found.
 */
public class FragmentF extends Fragment {
    private static final String LOG_TAG = FragmentF.class.getSimpleName();
    private static final String NESTED_FRAGMENT_TAG = FragmentA.class.getSimpleName();

    @BindView(R.id.parent_fragment_container)
    ViewGroup parentContainer;

    @Override
    public void onAttach(Activity activity) {
        Log.i(LOG_TAG, "onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreateView()");
        return inflater.inflate(R.layout.fragment_f, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

    }

    @OnClick(R.id.add_child_container)
    void addChildContainer() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.frame_container, parentContainer, false);
        parentContainer.addView(frameLayout);

        //getLayoutInflater() 这个方法只有v4才有
    }


    @OnClick(R.id.add_child_fragment)
    void addChildFragment() {

        Fragment fragmentA = getChildFragmentManager().findFragmentByTag(NESTED_FRAGMENT_TAG);
        if (fragmentA == null) {
            Log.i(LOG_TAG, "add new FragmentA !!");
            fragmentA = new FragmentA();
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_container, fragmentA, NESTED_FRAGMENT_TAG).commit();
        } else {
            Log.i(LOG_TAG, "found existing FragmentA, no need to add it again !!");
        }
    }


    @Override
    public void onStart() {
        Log.i(LOG_TAG, "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(LOG_TAG, "onResume()  --> Fragment is active");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(LOG_TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(LOG_TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(LOG_TAG, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(LOG_TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(LOG_TAG, "onDetach()");
        super.onDetach();
    }
}
