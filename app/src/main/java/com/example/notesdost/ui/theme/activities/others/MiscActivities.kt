package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.others.WifiActivity

class MiscActivities: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misc)

        val notesCard: CardView = findViewById(R.id.notesCard)
        val quizCard: CardView = findViewById(R.id.quizCard)
        val wifiCard: CardView = findViewById(R.id.wifiCard)
        val attendanceCard: CardView = findViewById(R.id.attendanceCard)

        notesCard.setOnClickListener {
            val intent = Intent(this@MiscActivities, YearSelectionActivity::class.java)
            startActivity(intent)
        }
        quizCard.setOnClickListener {
            val intent = Intent(this@MiscActivities, Quiz::class.java)
            startActivity(intent)
        }
        wifiCard.setOnClickListener {
            //Toast.makeText(this, "Under development.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MiscActivities, WifiActivity::class.java)
            startActivity(intent)
        }
        attendanceCard.setOnClickListener {
            //Toast.makeText(this, "Under development.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MiscActivities, Attendance::class.java)
            startActivity(intent)
        }
        val feedbackImg: ImageView = findViewById(R.id.feedbackImg)
        feedbackImg.setOnClickListener {
            val intent = Intent(this@MiscActivities, Feedback::class.java)
            startActivity(intent)
        }

    val menu: ImageView = findViewById(R.id.menuBar)
    menu.setOnClickListener {
        // Show popup menu when menu button is clicked
        showPopupMenu(it)
    }
}

    private fun showPopupMenu(view: View) {
        // Create a PopupMenu
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.main_menu, popupMenu.menu) // Inflate menu items

        // Handle menu item clicks
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.privacy -> {
                    // Open Privacy Policy Activity
                    val intent = Intent(this@MiscActivities, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@MiscActivities, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Feedback Activity
                    val intent = Intent(this@MiscActivities, Feedback::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@MiscActivities, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Handle menu item selection
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
                startActivity(Intent(this,Feedback::class.java))
                true
            }
            R.id.quiz -> {
                startActivity(Intent(this,Quiz::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}