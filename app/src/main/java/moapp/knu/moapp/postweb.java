package moapp.knu.moapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class postweb extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postweb);

        getWindow().setWindowAnimations(0);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Intent i = getIntent();
        String URL = i.getStringExtra("link");
        //Toast.makeText(getApplicationContext(),URL,Toast.LENGTH_SHORT).show();

        webView.loadUrl(URL);

    }
}
