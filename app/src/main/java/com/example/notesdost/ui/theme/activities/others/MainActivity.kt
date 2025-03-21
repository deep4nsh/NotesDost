package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import com.example.notesdost.R
import com.google.firebase.messaging.FirebaseMessaging
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Subscribe to the "Notification" topic
        FirebaseMessaging.getInstance().subscribeToTopic("Notification")
            .addOnCompleteListener { task ->
                var msg = "Done"
                if (!task.isSuccessful) {
                    msg = "Failed"
                }
                // You can show a toast message if needed
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.privacy -> {
                startActivity(Intent(this, Privacy::class.java))
                true
            }
            R.id.about -> {
                startActivity(Intent(this, About::class.java))
                true
            }
            R.id.feedback -> {
                startActivity(Intent(this, Feedback::class.java))
                true
            }
            R.id.quiz -> {
                startActivity(Intent(this, Quiz::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
