package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesdost.R

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        // Apply window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the LinkedIn image by its ID
        val linkedinImage: ImageView = findViewById(R.id.linkedInImg)
        val linkedinText: TextView = findViewById(R.id.linkedInText)

        // Set OnClickListener for LinkedIn Image
        linkedinImage.setOnClickListener {
            openLinkedInUrl()
        }

        // Set OnClickListener for LinkedIn Text
        linkedinText.setOnClickListener {
            openLinkedInUrl()
        }
    }

    // Function to open LinkedIn URL
    private fun openLinkedInUrl() {
        val linkedinUrl = "https://www.linkedin.com/in/deepanshdev/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
        startActivity(intent)
    }
}
