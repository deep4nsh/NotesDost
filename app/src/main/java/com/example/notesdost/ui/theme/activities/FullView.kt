package com.example.notesdost.ui.theme.activities

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesdost.R

class FullView : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the WebView
        webView = findViewById(R.id.pdfWebView)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        // Bypass cache
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.clearCache(true)

        // Google Drive file ID
        val googleDrivePdfUrl = "https://drive.google.com/file/d/1_AbQmYLFcOLooZdkSrDZ6AUINCMByNrY/view?usp=drive_link"
        webView.loadUrl(googleDrivePdfUrl)

    }
}
