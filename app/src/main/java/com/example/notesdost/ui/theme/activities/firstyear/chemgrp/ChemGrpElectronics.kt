package com.example.notesdost.ui.theme.activities.firstyear.chemgrp

import android.os.Bundle
import android.content.Intent
import android.view.MenuInflater
import android.view.View
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.others.About
import com.example.notesdost.ui.theme.activities.others.Feedback
import com.example.notesdost.ui.theme.activities.others.Privacy
import com.example.notesdost.ui.theme.activities.others.Quiz
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class ChemGrpElectronics : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var chapterList: MutableList<Chapter>
    private lateinit var topicsList: MutableList<Topics>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phy_grp_maths1)

        expandableListView = findViewById(R.id.expandableListView)
        addData()

        // Set the listener for expanding groups
        expandableListView.setOnGroupExpandListener { groupPosition ->
            // Collapse all other groups
            for (i in chapterList.indices) {
                if (i != groupPosition && expandableListView.isGroupExpanded(i)) {
                    expandableListView.collapseGroup(i)
                }
            }
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
                    val intent = Intent(this@ChemGrpElectronics, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@ChemGrpElectronics, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open About Activity
                    val intent = Intent(this@ChemGrpElectronics, Feedback::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@ChemGrpElectronics, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    private fun addData() {
        chapterList = mutableListOf()
        topicsList = mutableListOf()

        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1mM-K5XCEoa9I2Z9gPjqsibwvy8Fm17bJ/view?usp=sharing"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1k644yKf7XwhO-A9gP6WiSdybsH2M6N6H/view?usp=sharing"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1jhWyC0IQNn0QXSjbyZAWmh8BGLjYZ7ju/view?usp=sharing"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1STI5GoIkCZZp63rig3AyqrCa96ui_HYZ/view?usp=sharing"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1IR6xC3XajrbB0s5eQr8esuVTS8qjzCdL/view?usp=sharing"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Electronics Quantum PDF", "https://drive.google.com/file/d/1HyZnFfVCxPRFnD49SmmGO1rr-a-DdBvn/view?usp=sharing"))
        chapterList.add(Chapter("Electronics Quantum", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Question Bank", "https://miet.ac.in/media_image/resourses/2024_01_16_12_07_44_5550.pdf"))
        chapterList.add(Chapter("QB/QP", topicsList))

        sendData()
    }

    private fun sendData() {
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
