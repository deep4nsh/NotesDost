package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
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

class Quiz : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

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
        webView.loadUrl("https://quiz.abesaims.site/")

        // Set up ChatGPT icon to navigate to a new activity
        val chatGPTImg: ImageView = findViewById(R.id.chatGPTImg)
        chatGPTImg.setOnClickListener {
            val intent = Intent(this@Quiz, ChatGPT::class.java)
            startActivity(intent)
        }
    }

    // Configures WebView settings for better interaction and performance
    private fun configureWebView() {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                return false // Allow the WebView to load the URL internally
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                // Additional actions after page load, if needed
            }
        }

        webView.webChromeClient = WebChromeClient()
    }

    // JavaScript interface class for interacting with the WebView
    inner class QuizInterface {

        @JavascriptInterface
        fun getAnswerFromChatGPT(question: String) {
            fetchChatGPTResponse(question)
        }
    }

    // Function to fetch ChatGPT response using your backend server
    private fun fetchChatGPTResponse(question: String) {
        val url = "https://your-backend-url/chatgpt-response"
        val requestBody = JSONObject()
        requestBody.put("query", question)

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            requestBody,
            { response ->
                val chatResponse = response.getString("response")
                runOnUiThread {
                    displayChatGPTResponse(chatResponse)
                }
            },
            { error ->
                Toast.makeText(this, "Error fetching response: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        // Add the request to the queue
        Volley.newRequestQueue(this).add(request)
    }

    // Display the ChatGPT response in the WebView using JavaScript
    private fun displayChatGPTResponse(response: String) {
        val jsCode = "javascript:document.getElementById('chatgpt-answer').innerHTML = '${response.replace("'", "\\'")}';"
        webView.evaluateJavascript(jsCode, null)
    }
}
