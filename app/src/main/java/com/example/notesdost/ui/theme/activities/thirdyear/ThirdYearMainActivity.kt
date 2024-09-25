package com.example.notesdost.ui.theme.activities.thirdyear

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
import com.example.notesdost.ui.theme.activities.thirdyear.fifthsem.FifthSemActivity
import com.example.notesdost.ui.theme.activities.thirdyear.sixthsem.SixthSemActivity

class ThirdYearMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_year_main)

        // Initialize all CardView elements
        val fifthSemCard: CardView = findViewById(R.id.fifthSemCard)
        val sixthSemCard: CardView = findViewById(R.id.sixthSemCard)


        // Set onClickListeners for each CardView
        fifthSemCard.setOnClickListener {
            val intent = Intent(this@ThirdYearMainActivity, FifthSemActivity::class.java)
            startActivity(intent)
        }
        sixthSemCard.setOnClickListener {
            val intent = Intent(this@ThirdYearMainActivity, SixthSemActivity::class.java)
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
                    val intent = Intent(this@ThirdYearMainActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    val intent = Intent(this@ThirdYearMainActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
