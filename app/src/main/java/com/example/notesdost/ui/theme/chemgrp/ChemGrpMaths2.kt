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

class ChemGrpMaths2 : AppCompatActivity() {

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
            val intent = Intent(this@ChemGrpMaths2, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        val menu: ImageView = findViewById(R.id.menuBar)
        menu.setOnClickListener {
            val intent = Intent(this@ChemGrpMaths2, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addData() {
        chapterList = mutableListOf()
        topicsList = mutableListOf()

        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1joIIJOqlsnarDiKZxTe7qhfRgnK90yk-/view?usp=sharing"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1jbxaRnX4B4srqDRt-wImgtTDlgEZqmBw/view?usp=sharing"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1ny06B75wyBtu9JwWXg1W_e9FMCQjXroP/view?usp=sharing"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1Y10kQqCS70ci5O88cilRuwKOzCfhsEcO/view"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/105gyBYWYRplikiwr-melyo2Tn-86zLd4/view?usp=sharing"))
        chapterList.add(Chapter("Unit 5", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Mathematics-2 Quantum PDF", "https://drive.google.com/file/d/1dGavWjpLytT96Pr2NDZpufSlTvt1h7k0/view?usp=sharing"))
        chapterList.add(Chapter("Mathematics-2 Quantum", topicsList))

        sendData()
    }

    private fun sendData() {
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
