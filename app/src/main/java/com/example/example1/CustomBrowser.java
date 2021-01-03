package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import java.net.URI;
import java.net.URL;

public class CustomBrowser extends AppCompatActivity {
    EditText editText;
    WebView webView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_browser);
        btn=(Button)findViewById(R.id.btn1);
        editText=(EditText)findViewById(R.id.editText1);
        webView=(WebView)findViewById(R.id.webView1);
        WebSettings webSet=webView.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        try {
            Intent intent=getIntent();
            Uri data=intent.getData();
            URL url=null;
            try{
                url=new URL(data.getScheme(),data.getHost(),data.getPath());
            }catch (Exception e){
                e.printStackTrace();
            }
            editText.setText(url.toString());
            if(!url.toString().isEmpty())
                webView.loadUrl(url.toString());
        } catch (Exception exp){

        }
    }

    public void loadUrl(View view) {
        String url=editText.getText().toString();
        webView.loadUrl(url);
    }
}