package com.example.ddmeng.helloactivityandfragment.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToolbarFragment extends Fragment {
    public static final String TAG = ToolbarFragment.class.getSimpleName();

    @BindView(R.id.fragment_toolbar)
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView() " + savedInstanceState);
        return inflater.inflate(R.layout.toolbar_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated(): " + savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        toolbar.setTitle("Parent Fragment");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.e(TAG, "onCreateOptionsMenu()");
        menu.clear();
        if (getChildFragmentManager().getBackStackEntryCount() == 0) {
            inflater.inflate(R.menu.menu_parent_fragment, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "onOptionsItemSelected()");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume()  --> Fragment is active");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState(): " + outState);
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach()");
        super.onDetach();
    }

    @OnClick(R.id.button_show_child_fragment)
    void showChildFragment() {
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.parent_fragment_root, new ToolbarChildFragment(), ToolbarChildFragment.TAG)
                .addToBackStack(ToolbarChildFragment.TAG)
                .commit();
    }

    public boolean onBackPressed() {
        return getChildFragmentManager().popBackStackImmediate();
    }
}
