package com.sw.rssnews.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sw.rssnews.R;



public class FragmentWebView extends Fragment {
    private String currentURL;
    private WebView wv;

    public FragmentWebView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_web_view, container, false);
        Bundle getData = getArguments();
        currentURL= getData.getString("currenturl");
        if (currentURL != null) {


            wv = (WebView) rootView.findViewById(R.id.webview);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.setWebViewClient(new MyWebViewClient());
            wv.loadUrl(currentURL);
        }
        return rootView;
    }
        private class MyWebViewClient extends WebViewClient {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

}