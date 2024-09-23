package com.example.notesdost.ui.theme.activities

import android.os.Bundle
import android.content.Intent
import android.widget.ExpandableListView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.notesdost.R
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class PhyGrpGraphicsLab : AppCompatActivity() {

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
            val intent = Intent(this@PhyGrpGraphicsLab, PhysicsGroupActivity::class.java)
            startActivity(intent)
        }

        val menu: ImageView = findViewById(R.id.menuBar)
        menu.setOnClickListener {
            val intent = Intent(this@PhyGrpGraphicsLab, PhysicsGroupActivity::class.java)
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
        topicsList = mutableListOf()
        topicsList.add(Topics("All Sheets PDF", "https://drive.google.com/file/d/1pyIKOHf01XrHfdBR0iMufxf3NbjC-rcx/view?usp=sharing"))
        chapterList.add(Chapter("Sheet 1", topicsList))

        sendData()
    }

    private fun sendData() {
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }

}
