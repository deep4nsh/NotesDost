package com.example.notesdost.ui.theme.activities.thirdyear.sixthsem

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
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class SPM : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var chapterList: MutableList<Chapter>
    private lateinit var topicsList: MutableList<Topics>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spm)

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
                    val intent = Intent(this@SPM, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@SPM, About::class.java)
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

        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1WXVenWpRKABiOmr1ZPaEdXht4Q0y_oHf/view?usp=drive_link"))
        topicsList.add(Topics("Unit 1 PPT", "https://docs.google.com/presentation/d/1cqjm7bKgEY7xzvjSWdGbS6H9r4O4fez0/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/18gkSTK5I-tcjNGPocoIJS_gaDdZrBdvE/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 Network Planning PDF", "https://drive.google.com/file/d/1pgnyQYH0JeWQLMHo4rQl7aCSgN3f5_au/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1NJHv_iB4zX6S1kRAzUzen0gvtDPCvRLG/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1-1DxzcwKtn3S9mzuOAv1y0NNFlEvDS85/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PPT", "https://drive.google.com/file/d/11e0DQb19nFfQ0a53aTCMdZEaV64nDIJO/view?usp=sharing"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1mKtQIxsR9w3DdSNb6kzoaKAx2nlr2v3L/view?usp=drive_link"))
        topicsList.add(Topics("Unit 5 Theories Of Motivation PDF", "https://drive.google.com/file/d/1ehdOOaCvUUtbO56tNhIsY1kDMMoAl4re/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("PDF", "https://drive.google.com/file/d/1nbmyjOkLAP0MdoDQVPabhhjP0KipwRCu/view?usp=drive_link"))
        chapterList.add(Chapter("SPM Full Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("SPM Quantum PDF", "https://drive.google.com/file/d/1tymmEYcGkj-01zYpM0FJzPDW2cTBYoU0/view?usp=sharing"))
        chapterList.add(Chapter("SPM Quantum", topicsList))

        sendData()
    }

    private fun sendData() {
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
