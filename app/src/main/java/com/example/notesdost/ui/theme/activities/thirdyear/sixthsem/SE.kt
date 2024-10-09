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

class SE : AppCompatActivity() {

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
                    val intent = Intent(this@SE, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@SE, About::class.java)
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
        topicsList.add(Topics("Unit 1 PDF-1", "https://drive.google.com/file/d/1n4IaG9kigeMsuKTU4r2_UQGZXuLqI1G5/view?usp=drive_link"))
        topicsList.add(Topics("Unit 1 PDF-2", "https://drive.google.com/file/d/1kbHaMYa81Kao9xICW3UZJ3AfqLUtqImW/view?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PPT", "https://docs.google.com/presentation/d/1t-Vv7Wlue-yj-y3Xok8FsdaGuxv11Wtf/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 2", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF-1", "https://drive.google.com/file/d/13Na1rLLCpDJopfchNyxaWLDMBkyKKzVj/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PDF-2", "https://drive.google.com/file/d/1lbGnqqbOVNZjcXuDgERJg8YSgaiIEqhX/view?usp=drive_link"))
        topicsList.add(Topics("Unit 3 PPT-1", "https://docs.google.com/presentation/d/1ZJNeJU0QoWiKYil2quIk9lUcIDYmEjEn/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Unit 3 PPT-2", "https://docs.google.com/presentation/d/12PKPhjfpVq-3XeMX2WwiJnP-RdwKnqkj/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("Unit 3 PPT-3", "https://docs.google.com/presentation/d/1wyHDx_vfYMtUclW2Ahu1PenptsKTKEsz/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF-1", "https://drive.google.com/file/d/1yiZMt_eHeQqBFZJ42FZwOcZBkX_hDLkW/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PDF-2", "https://drive.google.com/file/d/1IBg9prg5WQ3WC5HIa7p9vasm_7jVNS6s/view?usp=drive_link"))
        topicsList.add(Topics("Unit 4 PPT-1", "https://docs.google.com/presentation/d/1AYKYPtiha5rAJUHnmdm-bj84SNM6MtqI/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("Unit 4 PPT-2", "https://docs.google.com/presentation/d/1Xuw30Q5fIDTcIhMgkr9gewY3baogjdPT/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 4", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF-1", "https://drive.google.com/file/d/16nzcOjItApCZzd4aUEX-rTNhaujWzX2v/view?usp=drive_link"))
        topicsList.add(Topics("Unit 5 PDF-2", "https://drive.google.com/file/d/1gttiYR9QT4FOJveap9vdXSW7ciQ8I04x/view?usp=drive_link"))
        topicsList.add(Topics("Unit 5 PPT-1", "https://docs.google.com/presentation/d/19oG72Q0yDjo_oyRGNoi7_mNdbYd-AeZc/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("Unit 5 PPT-2", "https://docs.google.com/presentation/d/1EUF4eoUQzzmUecHa5TjshapG7h6bI-At/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("SE Quantum Notes PDF", "https://drive.google.com/file/d/1CW-2gHY2s0kcu0MjwXQD45ZLP_a2_Fhq/view?usp=sharing"))
        topicsList.add(Topics("SE Quantum PDF", "https://drive.google.com/file/d/1Ea9iqy4ZXHLk1iciocvTWB_tH2N0IJp-/view?usp=drive_link"))
        chapterList.add(Chapter("SE Quantum", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Lab Notes PDF", "https://drive.google.com/drive/folders/1VJcp3bzk-neGukiwUsaURexFMxcl-BtJ?usp=drive_link"))
        chapterList.add(Chapter("SE Lab Notes", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("SE Question Bank PDF", "https://drive.google.com/file/d/16Z0HVa_y7lDzynUy046S0qyIHWWnVqaq/view?usp=sharing"))
        chapterList.add(Chapter("SE QB", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
