package com.example.notesdost.ui.theme.activities.secondyear

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.others.About
import com.example.notesdost.ui.theme.activities.others.Privacy
import com.example.notesdost.ui.theme.activities.others.Quiz

class SecondYearMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_year_main)

        // Initialize all CardView elements
        val automataCard: CardView = findViewById(R.id.automataCard)
        val dstlCard: CardView = findViewById(R.id.DSTLCard)
        val mathsCard: CardView = findViewById(R.id.mathsCard)
        val pythonCard: CardView = findViewById(R.id.pythonCard)
        val sensorCard: CardView = findViewById(R.id.sensorCard)
        val javaCard: CardView = findViewById(R.id.javaCard)
        val dsCard: CardView = findViewById(R.id.DSCard)
        val mpCard: CardView = findViewById(R.id.microprocessorCard)
        val osCard: CardView = findViewById(R.id.osCard)
        val coaCard: CardView = findViewById(R.id.coaCard)
        val uhvCard: CardView = findViewById(R.id.uhvCard)
        val cssCard: CardView = findViewById(R.id.cssCard)
        val tcCard: CardView = findViewById(R.id.tcCard)

        // Set onClickListeners for each CardView
        automataCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, Automata::class.java)
            startActivity(intent)
        }
        dstlCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, DSTL::class.java)
            startActivity(intent)
        }
        dsCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, DataStructure::class.java)
            startActivity(intent)
        }
        pythonCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, Python::class.java)
            startActivity(intent)
        }
        sensorCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, Sensors::class.java)
            startActivity(intent)
        }
        mpCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, MicroProcessor::class.java)
            startActivity(intent)
        }
        osCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, OS::class.java)
            startActivity(intent)
        }
        javaCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, Java::class.java)
            startActivity(intent)
        }
        mathsCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, Mathematics::class.java)
            startActivity(intent)
        }
        uhvCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, UHV::class.java)
            startActivity(intent)
        }
        coaCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, COA::class.java)
            startActivity(intent)
        }
        cssCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, CSS::class.java)
            startActivity(intent)
        }
        tcCard.setOnClickListener {
            val intent = Intent(this@SecondYearMainActivity, TC::class.java)
            startActivity(intent)
        }

        // Handle back arrow click
        val backArrow: ImageView = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            onBackPressed() // Go back to the previous activity
        }

        // Handle menu icon click to show PopupMenu
        val menu: ImageView = findViewById(R.id.menuBar)
        menu.setOnClickListener {
            showPopupMenu(it) // Show popup menu
        }
    }

    // Function to show the popup menu
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.main_menu, popupMenu.menu)

        // Handle menu item clicks
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.privacy -> {
                    val intent = Intent(this@SecondYearMainActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    val intent = Intent(this@SecondYearMainActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@SecondYearMainActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@SecondYearMainActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
