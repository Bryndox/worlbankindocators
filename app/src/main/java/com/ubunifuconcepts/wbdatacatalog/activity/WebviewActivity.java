package com.ubunifuconcepts.wbdatacatalog.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ubunifuconcepts.wbdatacatalog.R;
import com.ubunifuconcepts.wbdatacatalog.constant.Constants;

public class WebviewActivity extends AppCompatActivity {

    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Intent intent = getIntent();
        String indicatorUrl = intent.getStringExtra(Constants.INTENT_WEBVIEW_URL);
        String indicatorName = intent.getStringExtra(Constants.INTENT_WEBVIEW_NAME);

        setTitle(indicatorName);

        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

        browser.loadUrl(indicatorUrl);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {
            browser.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
