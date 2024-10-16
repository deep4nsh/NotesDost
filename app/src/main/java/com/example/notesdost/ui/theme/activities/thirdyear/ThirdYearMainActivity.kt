package com.example.notesdost.ui.theme.activities.thirdyear

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.notesdost.ui.theme.activities.thirdyear.fifthsem.FifthSemActivity
import com.example.notesdost.ui.theme.activities.thirdyear.sixthsem.SixthSemActivity

class ThirdYearMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_year_main)

        val fifthSemCard:CardView=findViewById(R.id.fifthSemCard)
        val sixthSemCard:CardView=findViewById(R.id.sixthSemCard)

        fifthSemCard.setOnClickListener{
            Log.d("ClickEvent", "Fifth Semester Card Clicked")
            val intent=Intent(this@ThirdYearMainActivity, FifthSemActivity::class.java)
            startActivity(intent)
        }
        sixthSemCard.setOnClickListener{
            val intent=Intent(this@ThirdYearMainActivity, SixthSemActivity::class.java)
            startActivity(intent)
        }
        val backArrow: ImageView = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // For newer versions
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
                    val intent = Intent(this@ThirdYearMainActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@ThirdYearMainActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@ThirdYearMainActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@ThirdYearMainActivity, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}