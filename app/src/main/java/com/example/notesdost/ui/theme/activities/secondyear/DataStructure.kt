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

class DataStructure : AppCompatActivity() {

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
                    val intent = Intent(this@DataStructure, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@DataStructure, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open About Activity
                    val intent = Intent(this@DataStructure, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@DataStructure, Quiz::class.java)
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
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1Kml5vQWRu7idi2PWQXQVqxBetr6Xo2wJ/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1PlViW5gikAaOEd-J6QJFW-2r84h0sxNj/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1pmLZ-KAEIOutYp-yws7ux_7EfSnCOdgR/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/13sBh3Vm_a76_UHHcD1nfwZc-VPyYT-t8/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1rmwPj7OLhOiMKc4d9TAbZvb3BNewy6Xd/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("DS Handwritten PDF", "https:https://drive.google.com/file/d/1sZnOe4Pb8p0bkJ_VO8BdBfC0cp3m4mu9/view?usp=drive_link"))
        topicsList.add(Topics("Graphs PDF", "https://drive.google.com/file/d/1tMFcVLxRTohzz8uFRgtv1V1CzuI6qQvh/view?usp=drive_link"))
        topicsList.add(Topics("Linked List PDF", "https://drive.google.com/file/d/1xih_9ywU3-PboQy0WzH_9UkfZcT8hmYh/view?usp=drive_link"))
        topicsList.add(Topics("Queue PDF", "https://drive.google.com/file/d/14URvVR_phWQ4hfDpwhAejDryE9wfLucG/view?usp=drive_link"))
        topicsList.add(Topics("Sparse Matrix PDF", "https://drive.google.com/file/d/1bKuSLOP393Kd8_ZWN_1m4WL_Y7NTA46Q/view?usp=drive_link"))
        topicsList.add(Topics("Stack PDF", "https://drive.google.com/file/d/1ZDtpA7fCw4G655gr29pK_-stG2rNH_xQ/view?usp=drive_link"))
        topicsList.add(Topics("Tree PDF", "https://drive.google.com/file/d/1ex5p0DgYK5Ksmdc1OPgiDGqfKLDXDiau/view?usp=drive_link"))
        topicsList.add(Topics("Queue PDF", "https://drive.google.com/file/d/14URvVR_phWQ4hfDpwhAejDryE9wfLucG/view?usp=drive_link"))
        topicsList.add(Topics("Topics Folder PDF", "https://drive.google.com/drive/folders/1WdhRjLFt5b1yICAb6KwtB3QlnpuwtMCH?usp=drive_link"))
        chapterList.add(Chapter("Topic-wise", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("PYQs PDF", "https://drive.google.com/drive/folders/1yyObvaGJWTRpYrZBQlKK-Ygjr4p03MDX?usp=drive_link"))
        chapterList.add(Chapter("PYQs", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Data Structure Quantum PDF", "https://drive.google.com/file/d/103QcDiEdOe144hm0P2kfmqB0S_QUzEOS/view?usp=sharing"))
        chapterList.add(Chapter("Data Structure Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
