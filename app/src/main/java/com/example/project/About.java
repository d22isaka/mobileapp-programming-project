package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class About extends AppCompatActivity {

    WebView myWebView;

    public void showInternalWebPage() {

        myWebView.loadUrl("file:///android_asset/about.html");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        myWebView = findViewById(R.id.my_webview);
        myWebView.setWebViewClient(new WebViewClient()); // Do not open in Chrome!

        WebView myWebView = (WebView) findViewById(R.id.my_webview);
        WebSettings webSettings = myWebView.getSettings();

        showInternalWebPage();
    }
}