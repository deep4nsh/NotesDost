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

class OOSD : AppCompatActivity() {

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
                    val intent = Intent(this@OOSD, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@OOSD, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@OOSD, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@OOSD, Quiz::class.java)
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
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1KwgUksb5_ImyOmNalW1kWSTQr5vJX_-I/view?usp=sharing"))
        topicsList.add(Topics("Unit 1 PPTs", "https://drive.google.com/drive/folders/1tW1GE8f2WPSqjvjFi1SOYP2k_Qcntu8E?usp=drive_link"))
        topicsList.add(Topics("Unit 1 Handouts", "https://drive.google.com/file/d/1c5IAfALIgywsKNXHH4rWE9p2APwglGew/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/10rxTKhEnzdKOUlNYJIAcMCHVHfWVSqfV/view?usp=drive_link"))
        topicsList.add(Topics("Unit 2 PPTs", "https://drive.google.com/drive/folders/1b8fYyO6T_9QoFtajQFTz9YRHLluGwRMR?usp=drive_link"))
        topicsList.add(Topics("Unit 2 Handouts", "https://drive.google.com/file/d/1IwdRIR65M_MVPIjdyQ-7DTzURrk5n7eR/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1JEl4336hoqFr6harjlK970LlzVziU9E4/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PPTs", "https://drive.google.com/drive/folders/10E-RByb718FFjA-ylNE3i0bOt5-tDu6o?usp=drive_link"))
        topicsList.add(Topics("Unit 3 Handouts", "https://drive.google.com/file/d/1feFRj9j3s5iPnsrWJhLGvJ15MePtzI7S/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1czX4ePE7jxFftiw77DRp5cWWvmSlLsQj/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PPTs", "https://drive.google.com/drive/folders/1rDqjObquLkar1Ay082o4VBD8FaP8SmNc?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1nPqgy9ZFFWZL7JhWV7sMAKkyQMUNa-yU/view?usp=drive_link"))
        topicsList.add(Topics("Unit 5 PPTs", "https://drive.google.com/drive/folders/18UVjPqp5ha38HPkirY40we9zZJ7l0pUN?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("OOSD Quantum PDF", "https://drive.google.com/file/d/1L5QZV9xCXNjzXyC4beD6D7DWiPlcH9Ah/view?usp=drive_link"))
        chapterList.add(Chapter("OOSD Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
