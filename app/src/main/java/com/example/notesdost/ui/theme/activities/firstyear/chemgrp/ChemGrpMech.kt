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
import com.example.notesdost.ui.theme.activities.others.Privacy
import com.example.notesdost.ui.theme.activities.others.Quiz
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class ChemGrpMech : AppCompatActivity() {

    private lateinit var backArrow: ImageView
    private lateinit var expandableListView: ExpandableListView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var chapterList: MutableList<Chapter>
    private lateinit var topicsList: MutableList<Topics>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phy_grp_maths1)

        // Initialize views here, after setContentView
        expandableListView = findViewById(R.id.expandableListView)
        backArrow = findViewById(R.id.backArrow)


        // Add data to the expandable list
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
                    val intent = Intent(this@ChemGrpMech, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@ChemGrpMech, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open About Activity
                    val intent = Intent(this@ChemGrpMech, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@ChemGrpMech, Quiz::class.java)
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

        // Add topics to the respective chapters
        topicsList = mutableListOf<Topics>()
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1Co6nYuhpw6Z0HXapkSf_hpCoOUtJlp_N/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF Part 1","https://drive.google.com/file/d/1C1pRMpX_KBkYREjkxHxFXkiOD_AY0kRT/view?usp=drive_link"))
        topicsList.add(Topics("Unit 2 PDF Part 2", "https://docs.google.com/document/d/112c0KqOGNNDvanvt5fTl4WKRlQyr2WBL/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF Part 1", "https://drive.google.com/file/d/1551WLUR-4EEJ6yY-9Yy8EV3p7btVQBzq/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PDF Part 2", "https://drive.google.com/file/d/1YIqP9xbUgxJLbkDouXDrgmz6pk2Ty8wZ/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF Complete", "https://drive.google.com/file/d/1GleIAPbh-xQdHF-U4ZV-ROclbG9NPJGX/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PDF Control Systems", "https://drive.google.com/file/d/1exeABzg4OKQuL5IYXd5XaUvwuu4gP7L7/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PDF Measurements", "https://drive.google.com/file/d/17LiIOV4OiDX4gfYoAtabk7XNGiu1a5Z5/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PDF Metrology", "https://drive.google.com/file/d/1ONannKX_osdXD9dLGGtpySo2XG4nl2cZ/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1iCRAuB4ueHZEKnO3jMP_shYW4AkRjZM8/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Mechanical Quantum PDF", "https://drive.google.com/file/d/15m8SRGv3oYN2M4aWJb0q0AV3qay12Goe/view?usp=sharing"))
        chapterList.add(Chapter("Mechanical Quantum", topicsList))

        sendData()
    }

    private fun sendData() {
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
