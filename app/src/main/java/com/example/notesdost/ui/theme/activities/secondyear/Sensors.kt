package com.example.notesdost.ui.theme.activities.secondyear

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

class Sensors : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var customAdapter: CustomAdapter
    private lateinit var chapterList: MutableList<Chapter>
    private lateinit var topicsList: MutableList<Topics>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_year_automata)

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
                    val intent = Intent(this@Sensors, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@Sensors, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@Sensors, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@Sensors, Quiz::class.java)
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
        topicsList.add(Topics("Part 1 PDF", "https://drive.google.com/file/d/1_a6syEiGMa8MnzgVZ5egL7ROya9jAbRL/view?usp=drive_link"))
        topicsList.add(Topics("Part 2 PDF", "https://drive.google.com/file/d/11Jh_z7dnaGe7Hl8Y8xH-hcr_u7tZ_s_w/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1gQ9QPMtwC7WPyJes_WF25bt0LhweJkup/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1znKiLgb41i9nGCvre02TgXTg9daHWJHC/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1uzxdhyj3pfpPt7sfcJikHPgpADcLpz8a/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1pkL65JHzye3IQq-p0xVf1gbsfPrkUE1S/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Sensor Quantum PDF", "https://drive.google.com/file/d/1YaBaUnol1gjUPi4PSyZNj0bSGuT5_2-P/view?usp=sharing"))
        chapterList.add(Chapter("Sensor Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
