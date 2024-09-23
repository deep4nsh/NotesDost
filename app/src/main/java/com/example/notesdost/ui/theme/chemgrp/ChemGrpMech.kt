package com.example.notesdost.ui.theme.chemgrp

import android.os.Bundle
import android.content.Intent
import android.widget.ExpandableListView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R
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

        // Set up the back arrow click listener
        backArrow.setOnClickListener {
            val intent = Intent(this@ChemGrpMech, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }

        val menu: ImageView = findViewById(R.id.menuBar)
        menu.setOnClickListener {
            val intent = Intent(this@ChemGrpMech, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }

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
    }

    private fun addData() {
        chapterList = mutableListOf()

        // Add topics to the respective chapters
        topicsList = mutableListOf<Topics>()
        topicsList.add(Topics("Unit 1 PDF", "https://docs.google.com/document/d/184aj4dz2659Nx7IDyr5vNGazo3GqsXqD/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://docs.google.com/document/d/112c0KqOGNNDvanvt5fTl4WKRlQyr2WBL/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://docs.google.com/document/d/1S2cIkMpykWUgoXjCaI5EvNapXphxiQX0/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://docs.google.com/document/d/1Hwv7-Y6mty9JZXrC-UKdnA8awriLdLIE/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://docs.google.com/document/d/1uoq8gAnWd1dMM4DpgXNzTH0VUf6Pqt3s/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
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
