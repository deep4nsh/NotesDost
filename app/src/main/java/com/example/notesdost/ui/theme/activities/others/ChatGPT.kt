package com.example.notesdost.ui.theme.activities.others

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesdost.R

class ChatGPT : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat_gpt)

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize WebView and load the URL
        webView = findViewById(R.id.webView)
        configureWebView()
        webView.loadUrl("https://chatgpt.com/")

        // Adjust WebView when keyboard is shown
        handleKeyboardVisibility()
    }

    private fun configureWebView() {
        val webSettings = webView.settings

        // Enable JavaScript for interactive content
        webSettings.javaScriptEnabled = true
        // Load the page in a mode that fits the content width
        webSettings.loadWithOverviewMode = true
        // Set the viewport to fit the page in the WebView
        webSettings.useWideViewPort = true
        // Disable caching to ensure fast fresh loading
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        // Disable zoom controls for a cleaner UI
        webSettings.builtInZoomControls = false
        webSettings.displayZoomControls = false

        // Use hardware acceleration for improved performance
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null)

        // Set a WebViewClient to handle URL loading within the WebView
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                return false // Allow the WebView to load the URL internally
            }
        }
    }

    private fun handleKeyboardVisibility() {
        val rootView = findViewById<View>(R.id.main)

        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect)

            val screenHeight = rootView.height
            val keypadHeight = screenHeight - rect.bottom

            // If the keypad height is greater than a threshold, it means the keyboard is visible
            if (keypadHeight > screenHeight * 0.15) {
                // Scroll the WebView up to avoid hiding content behind the keyboard
                webView.scrollBy(0, keypadHeight)
            }
        }
    }
}
