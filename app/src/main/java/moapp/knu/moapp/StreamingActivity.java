package moapp.knu.moapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StreamingActivity extends AppCompatActivity {
    WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("abc","abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        setContentView(R.layout.activity_streaming);
        Log.d("abc","abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        getWindow().setWindowAnimations(0);
        Log.d("abc","abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        webView = (WebView)findViewById(R.id.webView);
        Log.d("abc","abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        webView.setWebViewClient(new WebViewClient());
        Log.d("abc","abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc");
        Log.d("abc","abc");
        WebSettings webSettings = webView.getSettings();
        Log.d("abc","abc");
        webSettings.setJavaScriptEnabled(true);
        Log.d("abc","abc");
        webView.loadUrl("218.157.242.96:8081");
        Log.d("abc","abc");
    }
}
