package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import com.example.notesdost.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

            else -> super.onOptionsItemSelected(item)
        }
    }
}