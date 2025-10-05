package com.example.notesdost.ui.theme.activities.thirdyear.sixthsem

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
import com.example.notesdost.ui.theme.activities.thirdyear.sixthsem.COISecond

class SixthSemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth_sem)

        // Initialize all CardView elements
        val bigDataCard: CardView = findViewById(R.id.bdCard)
        val cnCard: CardView = findViewById(R.id.cnCard)
        val coi_iiCard: CardView = findViewById(R.id.coi_IICard)
        val seCard: CardView = findViewById(R.id.seCard)
        val spmCard: CardView = findViewById(R.id.spmCard)
        val webTechCard: CardView = findViewById(R.id.webTechCard)



        // Set onClickListeners for each CardView
        bigDataCard.setOnClickListener {
            val intent = Intent(this@SixthSemActivity, BigData::class.java)
            startActivity(intent)
        }
        cnCard.setOnClickListener {
            val intent = Intent(this@SixthSemActivity, CN::class.java)
            startActivity(intent)
        }
        coi_iiCard.setOnClickListener {
            val intent = Intent(this@SixthSemActivity, COISecond::class.java)
            startActivity(intent)
        }
        seCard.setOnClickListener {
            val intent = Intent(this@SixthSemActivity, SE::class.java)
            startActivity(intent)
        }
        spmCard.setOnClickListener {
            val intent = Intent(this@SixthSemActivity, SPM::class.java)
            startActivity(intent)
        }
        webTechCard.setOnClickListener {
            val intent = Intent(this@SixthSemActivity, WebTech::class.java)
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
                    val intent = Intent(this@SixthSemActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    val intent = Intent(this@SixthSemActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@SixthSemActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                // Open Quiz Activity
                val intent = Intent(this@SixthSemActivity, Quiz::class.java)
                startActivity(intent)
                true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
