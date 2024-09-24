package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            // Find the VideoView from the layout
            val videoView: VideoView = findViewById(R.id.splashVideo)

            // Load the video from the res/raw folder
            val videoUri = Uri.parse("android.resource://$packageName/${R.raw.splash}")
            videoView.setVideoURI(videoUri)

            // Set listener for when the video completes playing
            videoView.setOnCompletionListener {
                try {
                    // After video finishes, navigate to YearSelectionActivity
                    val intent = Intent(this@SplashActivity, YearSelectionActivity::class.java)
                    startActivity(intent)
                    finish() // Finish SplashActivity to remove it from the back stack
                } catch (e: Exception) {
                    Log.e("SplashActivity", "Error starting YearSelectionActivity", e)
                }
            }
            // Start playing the video
            videoView.start()
        } catch (e: Exception) {
            Log.e("SplashActivity", "Error during video playback", e)
        }
    }
}
