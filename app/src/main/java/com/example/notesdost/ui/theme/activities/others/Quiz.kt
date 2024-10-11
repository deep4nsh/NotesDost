package com.example.notesdost.ui.theme.activities.others

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesdost.R

class Quiz : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var webSettings: WebSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_privacy)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        webView = findViewById(R.id.webView)
        webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl("https://quiz.abesaims.site/")
    }
}
