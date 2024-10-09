package com.example.notesdost.ui.theme.activities.firstyear.chemgrp

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

class ChemistryGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chemistry_group)

        val maths1Card: CardView = findViewById(R.id.maths1Card)
        val maths2Card: CardView = findViewById(R.id.maths2Card)
        val chemistryCard: CardView = findViewById(R.id.chemistryCard)
        val electronicsCard: CardView = findViewById(R.id.electronicsCard)
        val softSkillCard: CardView = findViewById(R.id.softSkillCard)
        val mechanicalCard: CardView = findViewById(R.id.mechanicalCard)
        val electronicsLabCard: CardView = findViewById(R.id.electronicsLabCard)
        val workshopLabCard: CardView = findViewById(R.id.workshopLabCard)
        val chemistryLabCard: CardView = findViewById(R.id.chemistryLabCard)

        maths1Card.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpMaths1::class.java)
            startActivity(intent)
        }
        maths2Card.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpMaths2::class.java)
            startActivity(intent)
        }
        electronicsCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpElectronics::class.java)
            startActivity(intent)
        }
        softSkillCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpSoftSkill::class.java)
            startActivity(intent)
        }
        chemistryCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpChemistry::class.java)
            startActivity(intent)
        }
        mechanicalCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpMech::class.java)
            startActivity(intent)
        }
        electronicsLabCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpElectronicsLab::class.java)
            startActivity(intent)
        }
        workshopLabCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpWorkshopLab::class.java)
            startActivity(intent)
        }
        chemistryLabCard.setOnClickListener {
            val intent = Intent(this@ChemistryGroupActivity, ChemGrpChemistryLab::class.java)
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
                    val intent = Intent(this@ChemistryGroupActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@ChemistryGroupActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open About Activity
                    val intent = Intent(this@ChemistryGroupActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
