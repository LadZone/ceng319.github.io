package com.ladzone.testpi1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class web extends AppCompatActivity {
    private WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wv1=(WebView)findViewById(R.id.webView);
        //wv1.setWebViewClient(new MyBrowser());
        String s = getIntent().getStringExtra("EXTRA_SESSION_ID");

        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(s);
    }
}
