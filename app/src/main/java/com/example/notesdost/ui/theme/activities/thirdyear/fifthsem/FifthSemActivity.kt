package com.example.notesdost.ui.theme.activities.thirdyear.fifthsem

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

class FifthSemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_sem)

        // Initialize all CardView elements
        val coiCard: CardView = findViewById(R.id.coiCard)
        val daaCard: CardView = findViewById(R.id.daaCard)
        val davCard: CardView = findViewById(R.id.davCard)
        val dbmsCard: CardView = findViewById(R.id.dbmsCard)
        val oosdCard: CardView = findViewById(R.id.oosdCard)
        val scCard: CardView = findViewById(R.id.scCard)


        // Set onClickListeners for each CardView
        coiCard.setOnClickListener {
            val intent = Intent(this@FifthSemActivity, COI::class.java)
            startActivity(intent)
        }
        daaCard.setOnClickListener {
            val intent = Intent(this@FifthSemActivity, DAA::class.java)
            startActivity(intent)
        }
        davCard.setOnClickListener {
            val intent = Intent(this@FifthSemActivity, DataAnalyticsVisualization::class.java)
            startActivity(intent)
        }
        dbmsCard.setOnClickListener {
            val intent = Intent(this@FifthSemActivity, DBMS::class.java)
            startActivity(intent)
        }
        scCard.setOnClickListener {
            val intent = Intent(this@FifthSemActivity, SoftComputing::class.java)
            startActivity(intent)
        }
        oosdCard.setOnClickListener {
            val intent = Intent(this@FifthSemActivity, OOSD::class.java)
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
                    val intent = Intent(this@FifthSemActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    val intent = Intent(this@FifthSemActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@FifthSemActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@FifthSemActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
