package com.example.notesdost.ui.theme.activities.thirdyear.sixthsem

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

class BigData : AppCompatActivity() {
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
                    val intent = Intent(this@BigData, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@BigData, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open Quiz Activity
                    val intent = Intent(this@BigData, Quiz::class.java)
                    startActivity(intent)
                    true
                }
                R.id.quiz -> {
                    // Open Quiz Activity
                    val intent = Intent(this@BigData, Quiz::class.java)
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
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/drive/folders/15Rl-TibaEoPl7RZ4t7cHf6_OIYUih-II?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/drive/folders/1fT1Hc0lQQaBE517jvkhHFy_npUfyrKyX?usp=drive_link"))
        topicsList.add(Topics("Unit 2 Part-2 PDF", "https://drive.google.com/file/d/1nD_qL__0TvIYGOC4-ePxW_rdLn5Me8Ut/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/drive/folders/1P1_Z7hiwPrIMs3N5I2QeNSv9fYjP7cEF?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/drive/folders/1FfjGlOMA8ojdoreS09YbvM03LOMNLreZ?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/drive/folders/1HUtOQWQsuQIm0wlpOCl69WP3V5P9SFvD?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Book-1 PDF", "https://drive.google.com/file/d/1RMPk-oH8wG5baYVn1Gb94Vu6JCstoeg0/view?usp=drive_link"))
        topicsList.add(Topics("Book-2 PDF", "https://drive.google.com/file/d/1C-Xx5ouebEi3ehH-h2XWyqk3cCI9A_Nu/view?usp=drive_link"))
        chapterList.add(Chapter("Big Data Book", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("NoSQL Document", "https://docs.google.com/document/d/1hpkSnLJRQlwbT-8g68Vok46BSvMi5unf/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        chapterList.add(Chapter("NoSQL Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("File PDF", "https://drive.google.com/drive/folders/16Rj5cR5C4HN4EJxrabHjAcgOmEJNpfFD?usp=drive_link"))
        chapterList.add(Chapter("Course File", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("QP PDF", "https://drive.google.com/drive/folders/1eYQR3-MQfhazGOxPT0IgXOFB1GiRYNpm?usp=drive_link"))
        chapterList.add(Chapter("QP", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Quantum PDF", "https://drive.google.com/file/d/1cO2j1W_hejdTGiHxRVzGtMsie5xCbCS4/view?usp=sharing"))
        chapterList.add(Chapter("Big Data Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
