package com.example.notesdost.ui.theme.activities.firstyear

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
import com.example.notesdost.ui.theme.activities.firstyear.chemgrp.ChemistryGroupActivity
import com.example.notesdost.ui.theme.activities.firstyear.phygrp.PhysicsGroupActivity

class FirstYearMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_year_main)

        val physicsGroupCard:CardView=findViewById(R.id.physicsGroupCard)
        val chemistryGroupCard: CardView=findViewById(R.id.chemistryGroupCard)

        physicsGroupCard.setOnClickListener{
            val intent=Intent(this@FirstYearMainActivity, PhysicsGroupActivity::class.java)
            startActivity(intent)
        }
        chemistryGroupCard.setOnClickListener{
            val intent=Intent(this@FirstYearMainActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        val backArrow: ImageView = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            // Go back to the previous activity
            onBackPressed()
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
                    val intent = Intent(this@FirstYearMainActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@FirstYearMainActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}