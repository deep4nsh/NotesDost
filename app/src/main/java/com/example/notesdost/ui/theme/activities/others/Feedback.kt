package com.example.notesdost.ui.theme.activities.others

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesdost.R

class Feedback : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var webSettings: WebSettings
    private var filePathCallback: ValueCallback<Array<Uri>>? = null
    private lateinit var progressBar: ProgressBar  // Corrected ProgressBar declaration

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetMultipleContents()) { uris ->
            if (uris.isNotEmpty()) {
                filePathCallback?.onReceiveValue(uris.toTypedArray())
            } else {
                filePathCallback?.onReceiveValue(null)
            }
            filePathCallback = null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)

        // Initialize ProgressBar
        progressBar = findViewById(R.id.progressBar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Check for permission to read external storage
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        webView = findViewById(R.id.webViewFeedback)
        webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                view: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                this@Feedback.filePathCallback = filePathCallback
                galleryLauncher.launch("image/*") // Open the gallery to select images
                return true
            }
        }

        // Load the feedback form
        webView.loadUrl("file:///android_asset/feedback_form.html")
    }

    // Call this method when you start the form submission
    private fun showLoader() {
        progressBar.visibility = View.VISIBLE
    }

    // Call this method after the form is submitted
    private fun hideLoader() {
        progressBar.visibility = View.GONE
    }

    // Example form submission logic
    private fun submitForm() {
        showLoader()

        // Assuming the form has a JavaScript function called submitForm
        webView.evaluateJavascript("submitForm()") { result ->
            // Handle the result (success or failure)
            hideLoader()
            // You might want to show a success message or handle the result further
            Toast.makeText(this, "Form submitted: $result", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
