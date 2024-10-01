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
import com.example.notesdost.ui.theme.adapter.CustomAdapter
import com.example.notesdost.ui.theme.model.Chapter
import com.example.notesdost.ui.theme.model.Topics

class CN : AppCompatActivity() {

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
                    val intent = Intent(this@CN, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@CN, About::class.java)
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
        topicsList.add(Topics("Bipolar Encoding Scheme AMI PDF", "https://drive.google.com/file/d/1jQtFB0mImrv8Qq2214NEngxjwyCzh03l/view?usp=drive_link"))
        topicsList.add(Topics("Datagram Packet Switching PDF", "https://drive.google.com/file/d/1J4M2gP1E-tQikRN3cUa36dhOt-FcmnOB/view?usp=drive_link"))
        topicsList.add(Topics("Introduction Computer Network PDF", "https://drive.google.com/file/d/1RjuOaqXaVZzZ2lDyCAr-ovY8l8CDsKlD/view?usp=drive_link"))
        topicsList.add(Topics("Network Performance Parameters PDF", "https://drive.google.com/file/d/1N6z0AU2hKrFWgsdlYEX8erWZjMbkqyjs/view?usp=drive_link"))
        topicsList.add(Topics("Transmission Media PDF", "https://drive.google.com/file/d/1QKZha1QIaHB2HgBfN8OfUgUxr3DzzFjw/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Framing PPT", "https://docs.google.com/presentation/d/1zIHS4KUBKSxVEvL6ILgezMuCse8JyRpX/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Flow Control PPT", "https://docs.google.com/presentation/d/1V8fa6ucQRQcbZRaMLheVFDnG_sRk_hEM/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Error Detection and Correction PPT", "https://docs.google.com/presentation/d/1wkqxV0sEft9eLGFYdydWQRm2yqGkfV4g/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Channel Allocation PPT", "https://docs.google.com/presentation/d/17m8a5PRWF5mIp5k1M6A8pv6Wc2j-WVj7/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Physical and Logical Topologies PPT", "https://docs.google.com/presentation/d/1xtClt7voUkURnw9ZfFE0nKusqdzmjDKJ/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Switching Fundamentals PPT", "https://docs.google.com/presentation/d/1i942A3zgkEgbtfG-F8Q5ND2_-_rGJAk8/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("VLAN PPT", "https://docs.google.com/presentation/d/13JsNwXSYAQRO3BpiFQgldDB7oe0BIhnP/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Learning Bridges & Spanning Tree Algorithm PPT", "https://docs.google.com/presentation/d/1W2Iv55-VSeWNeJw9Rxy9ylM0Pk_hbE21/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("ARQ PDF", "https://drive.google.com/file/d/1MxW2tmlFSlUxrkDNb6GBFiFUlCwZTbev/view?usp=drive_link"))

        chapterList.add(Chapter("Unit 2", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1m8Bd_ijDie_fd63mIe9OyibgeFRORG7k/view?usp=sharing"))
        chapterList.add(Chapter("Unit 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1QoJG_ztnZMm-1aQnhSHPegP7x_s4VhuB/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 4", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1sfxpF8ikd6fdva9XDzJmrmhWvnSp85Yu/view?usp=sharing"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("PPTs Link", "https://drive.google.com/drive/folders/1hWEmBZNzcc2G6xgwFOttWETiUqfM_jKA?usp=drive_link"))
        chapterList.add(Chapter("PPTs", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("CN Quantum PDF", "https://drive.google.com/file/d/1EoqYA8Q7obJrzGKI-D-2KpXut8bfPFFZ/view?usp=sharing"))
        chapterList.add(Chapter("CN Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
