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
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class DAA : AppCompatActivity() {

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
                    val intent = Intent(this@DAA, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@DAA, About::class.java)
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
        topicsList.add(Topics("Unit 1 PDF-1", "https://drive.google.com/file/d/17HM4wSRw9zSreEPV162AT2f7KW9P0-45/view?usp=drive_link"))
        topicsList.add(Topics("Unit 1 PDF-2", "https://drive.google.com/file/d/1_sEIgxlvtL5LjuBqFD6Ro3CYMpLlVADR/view?usp=drive_link"))
        topicsList.add(Topics("Unit 1 PDF-3", "https://drive.google.com/file/d/1AvmhYStO_2mZM0_AgoRsoAVnzQNOXHGh/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1lOSy4FV7c-hbARxCbjawHnDA9v_ZU9Pf/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1OTHAcp-eug_zLShFP_22WPM5cfUtiIbq/view?usp=drive_link"))
        topicsList.add(Topics("Unit 2-3 PDF", "https://drive.google.com/file/d/1fNKfU8zOLG-J8qKCJ115C4hsdf7feeP3/view?usp=drive_link"))
        topicsList.add(Topics("Greedy-1 PDF", "https://drive.google.com/file/d/17VjqbWMyYaQlUaeNp6Fqkf049J-zo4pW/view?usp=drive_link"))
        topicsList.add(Topics("Greedy-2 PDF", "https://drive.google.com/file/d/14yS_sOfSFHrUHSaUP62_c70aoT1PmxBo/view?usp=drive_link"))
        topicsList.add(Topics("Greedy-3 PDF", "https://drive.google.com/file/d/1klGIMKFGTasAZb6bAjOVdMlhpVoU3Iia/view?usp=drive_link"))
        topicsList.add(Topics("Divide Conquer PDF", "https://drive.google.com/file/d/1QxK60J-H9kNYqb7Tqh2IUThsS37UaHAn/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 2 & 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1X8lgOeULci3H2MgytaDu_JxZRdiLSsu0/view?usp=drive_link"))
        topicsList.add(Topics("All pair shortest path PDF", "https://drive.google.com/file/d/1LnfXJB1rNtEGfz7BcraD9oaeWTzE2RV0/view?usp=drive_link"))
        topicsList.add(Topics("Backtracking PDF", "https://drive.google.com/file/d/1NU-f6IcNwxaDVExGdNAEjZsZ9SLQ1hLA/view?usp=drive_link"))
        topicsList.add(Topics("Branch and Bound PDF", "https://drive.google.com/file/d/1qL0EBwUWB3aKpVlZXAhbdKjfWMM1xSv3/view?usp=drive_link"))
        topicsList.add(Topics("Resource Allocation PDF", "https://drive.google.com/file/d/1FGYpMO2UBkWry3PuwSbf8NJXVS8obWKX/view?usp=drive_link"))
        topicsList.add(Topics("Knapsack, Matrix Chain Multiplication PDF", "https://drive.google.com/file/d/1_PIte5Amu-7CPsXTqaDvbSLFyM_fckPN/view?usp=drive_link"))
        topicsList.add(Topics("TSP PDF", "https://drive.google.com/file/d/1yfzcpRRgXgMxEa88K1RHHAdOdzI7_ukR/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF-1", "https://drive.google.com/file/d/18kCRj_BeiJsR1E_-pk_LVk7gEvLQeGLi/view?usp=drive_link"))
        topicsList.add(Topics("UNit 5 PDF-2", "https://drive.google.com/file/d/1yvoNe8HMxAyMy6KJOuI2v-yplpChcDxC/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("DAA Quantum PDF", "https://drive.google.com/file/d/1lWNEfw9bHXOqOz43fAlxHKhUGmPBQGiC/view?usp=drive_link"))
        chapterList.add(Chapter("DAA Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
