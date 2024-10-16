package com.example.notesdost.ui.theme.activities.others

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesdost.R

class Quiz : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_privacy)

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webView = findViewById(R.id.webView)
        configureWebView()
        webView.loadUrl("https://quiz.abesaims.site/")
    }

    private fun configureWebView() {
        val webSettings = webView.settings

        // Enable JavaScript and other settings for a better experience
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true

        // Enable smooth zooming (optional)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false

        // Use hardware acceleration for better performance
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null)

        // Set a WebViewClient to handle loading inside the WebView
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                return false
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                // Perform any additional actions when the page has finished loading
            }
        }

        // Use WebChromeClient to manage JavaScript dialogs, icons, titles, etc.
        webView.webChromeClient = WebChromeClient()
    }
}
