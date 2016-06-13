package com.example.ddmeng.helloactivityandfragment.state;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ddmeng.helloactivityandfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class Tab2Fragment extends Fragment {
    public static final String TAG = Tab2Fragment.class.getSimpleName();
    private static final String TEST_URL = "http://www.cnblogs.com/mengdd/";

    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.tab2_input)
    EditText input;
    @BindView(R.id.tab2_webview)
    WebView webView;
    private Bundle webViewState;

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate(): " + hashCode());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView(): " + savedInstanceState);
        return inflater.inflate(R.layout.tab2_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated(): " + savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        // if we set this to be false, the EditText value will not be restored even with id
//        input.setSaveEnabled(false);

        initWebView();
        if (webViewState != null) {
            //Fragment实例并未被销毁, 重新create view
            webView.restoreState(webViewState);
        } else if (savedInstanceState != null) {
            //Fragment实例被销毁重建
            webView.restoreState(savedInstanceState);
        } else {
            //全新Fragment
            webView.loadUrl(TEST_URL);
        }
    }

    @SuppressLint("JavascriptInterface")
    private void initWebView() {

        // Settings
        WebSettings settings = webView.getSettings();
        settings.setDefaultTextEncodingName("GBK");
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        // settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(this.getContext().getCacheDir().getAbsolutePath());
        settings.setDisplayZoomControls(false);


        webView.requestFocus();

        webView.setWebViewClient(new WebViewClient() {
        });

        webView.setWebChromeClient(new WebChromeClient() {

        });

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated(): " + savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.i(TAG, "onViewStateRestored(): " + savedInstanceState);
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume()  --> Fragment is active");
        super.onResume();
        webView.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause()");
        super.onPause();
        webView.onPause();

        //Fragment不被销毁(Fragment被加入back stack)的情况下, 依靠Fragment中的成员变量保存WebView状态
        webViewState = new Bundle();
        webView.saveState(webViewState);
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState(): " + outState);
        //Fragment被销毁的情况, 依靠outState保存WebView状态
        if (webView != null) {
            webView.saveState(outState);
        }
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()");
        if (webView != null) {
            container.removeView(webView);
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach()");
        super.onDetach();
    }

    @OnTextChanged(R.id.tab2_input)
    void onInputChanged(CharSequence s, int start, int before, int count) {
        Log.i(TAG, "onInputChanged(): " + s);
    }
}
