package com.example.notesdost.ui.theme.activities.others

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://192.168.1.254:8090/")

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                view?.evaluateJavascript(
                    "document.getElementById('username').value = '$username';" +
                            "document.getElementById('password').value = '$password';",
                    null
                )
            }
        }
    }
}
