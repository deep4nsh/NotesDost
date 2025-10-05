package com.example.notesdost.ui.theme.activities.others

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.notesdost.R
import org.json.JSONObject

class Attendance : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_attendance)

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize WebView and configure its settings
        webView = findViewById(R.id.webView)
        configureWebView()
        webView.addJavascriptInterface(QuizInterface(), "AndroidInterface")
        webView.loadUrl("https://abes.web.simplifii.com/index.php")
    }

    private fun configureWebView() {
        val webSettings = webView.settings

        // Enable essential features for better performance
        webSettings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE // Always load fresh content
            loadWithOverviewMode = true
            useWideViewPort = true
            builtInZoomControls = true
            displayZoomControls = false
            setSupportZoom(true)
            allowFileAccess = true
            allowContentAccess = true
        }

        // Improve rendering performance using hardware acceleration
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null)

        // Set a custom WebViewClient to handle page loading
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false // Allow internal URL loading for better performance
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                // Additional actions after page load if needed
            }
        }

        // Use WebChromeClient for JavaScript dialogs and UI features
        webView.webChromeClient = WebChromeClient()
    }

    // JavaScript interface for WebView interaction
    inner class QuizInterface {
        @JavascriptInterface
        fun getAnswerFromChatGPT(question: String) {
            fetchChatGPTResponse(question)
        }
    }

    // Function to fetch ChatGPT response using your backend server
    private fun fetchChatGPTResponse(question: String) {
        val url = "https://your-backend-url/chatgpt-response" // Replace with your backend URL
        val requestBody = JSONObject().apply {
            put("query", question)
        }

        val request = JsonObjectRequest(
            Request.Method.POST, url, requestBody,
            { response ->
                val chatResponse = response.optString("response", "No response")
                runOnUiThread {
                    displayChatGPTResponse(chatResponse)
                }
            },
            { error ->
                Toast.makeText(this, "Error fetching response: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(this).add(request)
    }

    // Display the ChatGPT response in the WebView using JavaScript
    private fun displayChatGPTResponse(response: String) {
        val jsCode = "javascript:document.getElementById('chatgpt-answer').innerHTML = '$response';"
        webView.evaluateJavascript(jsCode, null)
    }
}
