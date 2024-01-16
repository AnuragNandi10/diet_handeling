package com.example.dietdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class HeartDisease extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_disease);

        // Find the WebView by its unique ID
        WebView webView = findViewById(R.id.web);

        webView.loadUrl("https://faf0-2409-4061-4ec6-5f33-e0cb-6fbd-73e7-975.ngrok-free.app/");

        // this will enable the javascript.
        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //create a menu with two options: play round 1 or play round two
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.logout) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }
        return false;
    }
}