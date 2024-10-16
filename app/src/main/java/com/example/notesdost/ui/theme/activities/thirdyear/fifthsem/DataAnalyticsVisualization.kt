package com.example.notesdost.ui.theme.activities.thirdyear.fifthsem

import android.content.Intent
import android.os.Bundle
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

class DataAnalyticsVisualization : AppCompatActivity() {
    private lateinit var expandableListView: ExpandableListView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var chapterList: MutableList<Chapter>
    private lateinit var topicsList: MutableList<Topics>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coi)

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
                    val intent = Intent(this@DataAnalyticsVisualization, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@DataAnalyticsVisualization, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@DataAnalyticsVisualization, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@DataAnalyticsVisualization, Quiz::class.java)
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
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/16Sqj7d6d7-7b8uQf-Hjlo8ehLkw_40Y3/view?usp=drive_link"))
        topicsList.add(Topics("Unit 1 PPTs", "https://drive.google.com/drive/folders/167kbVRbPzK_P5j5FPcuOkdPsKgG7g1Nl?usp=drive_link"))
        topicsList.add(Topics("Unit 1 Other", "https://drive.google.com/file/d/1p18DRf9Whr_MfzgBSy_R_ImtK3oftcHe/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1FZBHH3vSJxnwGAcqOnxhzHXKlCorwht9/view?usp=drive_link"))
        topicsList.add(Topics("Unit 2 PPTs", "https://drive.google.com/drive/folders/1Z5nwp5SVKgIzq4XU4c5lLxx3DRnQmw1a?usp=drive_link"))
        topicsList.add(Topics("Unit 2 Other", "https://drive.google.com/file/d/1lbzsWLbpUmnBqBDwNhxcSDTX6-ihA0ET/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/16Nt_XDrIlhuqGPWajVIZuGubctggKeCg/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PPTs", "https://drive.google.com/drive/folders/1tInqUMKQYGhLcRrKwRQGH0qd8bKaniyV?usp=drive_link"))
        topicsList.add(Topics("Unit 3 Other", "https://drive.google.com/file/d/1YKnveRv0fu-dVCCYNOYb4cVrvgKALOlJ/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1TsSh8xTiTmaDzMZblUWqC7GI07RN4pDr/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PPTs", "https://drive.google.com/drive/folders/1wMhQ4WQZML5jx17VWGbaz49DGOiyXy1M?usp=drive_link"))
        topicsList.add(Topics("Unit 4 Other", "https://drive.google.com/file/d/1w6P86NAZ4OG7i5HeG54zKRtCbmUtyIQn/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1dCY1U88v_5tXTmZudlVDx2dKokNVt4iv/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("DAV Quantum PDF", "https://drive.google.com/file/d/14nitiFh6jwybU3fDH8KMUJ4qSG1tE2pI/view?usp=drive_link"))
        chapterList.add(Chapter("DAV Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
