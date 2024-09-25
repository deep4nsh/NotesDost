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
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class Automata : AppCompatActivity() {
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
                    val intent = Intent(this@Automata, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@Automata, About::class.java)
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
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1yoJVchbEHpwwZRhnfAw6rGfMKc39edCd/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))

        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1x-JpdK5YhVb57aFnh1wByy0jzx6LszRE/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1YZB8DeAT9TLoZKIuaXCSoiF0YHMGIf3L/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1YVhWUQO4QCW4GQStdZL44Eyg1JuDVjlm/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1WFsuLlqUlDVc3KNY765hsE67XkZa8Ks0/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Handwritten PDF", "https://drive.google.com/file/d/1e7MNqLn9AvjnGa1mZFav2BbahNAfxJni/view?usp=drive_link"))
        chapterList.add(Chapter("Handwritten Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Linked List PDF", "https://drive.google.com/file/d/1HXo9_fR2ywinVgJBT8-jVbKCGLp5N9WB/view?usp=drive_link"))
        chapterList.add(Chapter("Linked List Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Stack PDF", "https://drive.google.com/file/d/1mbVBm5hAIoQEX8u0jcgZMcVkJ1zTGTn_/view?usp=drive_link"))
        chapterList.add(Chapter("Stack Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Queue PDF", "https://drive.google.com/file/d/18g15OOHHHabtOD8gmIcY7CRCoRh_lxBg/view?usp=drive_link"))
        chapterList.add(Chapter("Queue Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Tree PDF", "https://drive.google.com/file/d/1f1ezzf62biyLEQdQ_sZQhw_Oflt6EmEZ/view?usp=drive_link"))
        chapterList.add(Chapter("Tree Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Graph PDF", "https://drive.google.com/file/d/1EJ6aOiTW85KRxK21YexPJlXB_McKEn4V/view?usp=drive_link"))
        chapterList.add(Chapter("Graph Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Sparse Matrix PDF", "https://drive.google.com/file/d/1PJDVQWVQF0QJw5ez3W3RQcJx4sMH57IO/view?usp=drive_link"))
        chapterList.add(Chapter("Sparse Matrix Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Topic Wise PDF", "https://drive.google.com/drive/folders/1ZgaDT4rtgtnD6mEp7tPuvgdQ6J1Wnxk5?usp=sharing"))
        chapterList.add(Chapter("Topics", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("PYQ PDF", "https://drive.google.com/drive/folders/1LkGMZbokEg62Wdf9tLq2nr3baHIk0Nxa?usp=drive_link"))
        chapterList.add(Chapter("PYQs", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Automata Quantum PDF", "https://drive.google.com/file/d/12wm1PsoMbjYi5IkYEy34SB_EdtgSW_yx/view?usp=drive_link"))
        chapterList.add(Chapter("Automata Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
