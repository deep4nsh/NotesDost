package com.example.notesdost.ui.theme.phygrp

import android.os.Bundle
import android.content.Intent
import android.widget.ExpandableListView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class PhyGrpPhyLab : AppCompatActivity() {

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
            val intent = Intent(this@PhyGrpPhyLab, PhysicsGroupActivity::class.java)
            startActivity(intent)
        }
        val menu: ImageView = findViewById(R.id.menuBar)
        menu.setOnClickListener {
            val intent = Intent(this@PhyGrpPhyLab, PhysicsGroupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addData() {
        chapterList = mutableListOf()
        topicsList = mutableListOf()

        topicsList = mutableListOf()
        topicsList.add(Topics("Lab Manual PDF", "https://drive.google.com/file/d/1hHX1-hwtilgDhslGV7JP1DWVAeW0hoTt/view?usp=drive_link"))
        chapterList.add(Chapter("Lab Manual Physics", topicsList))

        sendData()
    }

    private fun sendData() {
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
