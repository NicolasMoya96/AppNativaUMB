package com.example.appnativaumb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PaginaUMBActivity extends AppCompatActivity {

    private WebView webViewUmb;
    private Button btnVolver;
    private static final String URL_UMB = "https://umb.edu.co/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_umb);

        webViewUmb = findViewById(R.id.webViewUmb);
        btnVolver = findViewById(R.id.btnVolver);

        webViewUmb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webViewUmb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webViewUmb.loadUrl(URL_UMB);

        // Botón para volver al menú principal
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaUMBActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webViewUmb.canGoBack()) {
            webViewUmb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}