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

class WebTech : AppCompatActivity() {

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
                    val intent = Intent(this@WebTech, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@WebTech, About::class.java)
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
        topicsList.add(Topics("Unit 1 PDF", "https://drive.google.com/file/d/1TZ3GVGoEypG_N8Ch-H2bz_1zHvqZH_d5/view?usp=drive_link"))
        topicsList.add(Topics("Unit 1 PPT", "https://docs.google.com/presentation/d/1QHaGRMlD8B2HHLypbHkIrijiosHP_z1X/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("Unit 1 Handwritten Notes", "https://drive.google.com/drive/folders/1fBmLnkg7pSm9OtQGjunSwoOsxFCJ1rH2?usp=drive_link"))
        chapterList.add(Chapter("Unit 1", topicsList))


        topicsList = mutableListOf() // Reset topicsList for new chapter
        topicsList.add(Topics("Unit 2 PDF", "https://drive.google.com/file/d/1rLMU3y6lNEoZFuqgZNiYjOCNdjGxBtx2/view?usp=drive_link"))
        topicsList.add(Topics("Anchor Pseudo Classes PPT", "https://docs.google.com/presentation/d/1AmKfiUqb-N9cyiv7JBdcQRIBHeDRGR1m/edit?usp=sharing&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("XML PPT", "https://docs.google.com/presentation/d/1XQRMU4tBcyBqBrU7rq6KZQwMy2b8-b9T/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("CSS PPT", "https://docs.google.com/presentation/d/1UIM7yh53TpYB_6Q0p3q5BHSEJ8mPlvr_/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("HTML PPT", "https://docs.google.com/presentation/d/1MGtxgmWqb5spcIrDZthhDvzZu1uvIHWc/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("HTML Examples", "https://drive.google.com/drive/folders/1YO0O0MWy4xJIYUkvvett_dFsdKkeEMDi?usp=drive_link"))
        topicsList.add(Topics("CSS Examples", "https://drive.google.com/drive/folders/1Negg3ytqalcTwHPwFVkK4rKY1XWc-j7M?usp=drive_link"))

        chapterList.add(Chapter("Unit 2", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 3 PDF", "https://drive.google.com/file/d/1DKdzpisfXVakBhM1QjISdNdrrW-Kqm-m/view?usp=drive_link"))
        topicsList.add(Topics("JS PPT", "https://docs.google.com/presentation/d/1vk0G_wD7wOJ36hnu29fAuUJYETlVBD2K/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Networking PDF", "https://drive.google.com/file/d/1Xbjcv3W9vAGZN7RZYffh3LKs4nA53cmP/view?usp=drive_link"))
        topicsList.add(Topics("Networking PPT", "https://docs.google.com/presentation/d/1f_uoeuJmwFYFu7U0anNzu9moEyGnejYZ/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        topicsList.add(Topics("JS Folder", "https://drive.google.com/drive/folders/1_64_Q9mik25IbjMqCwnPboX8Ytk6gOcP?usp=drive_link"))
        chapterList.add(Chapter("Unit 3", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 4 PDF", "https://drive.google.com/file/d/1O1Oyq_5OpxYYonKniaIYvfNnJjLXLOXD/view?usp=drive_link"))
        topicsList.add(Topics("JDBC PPT", "https://docs.google.com/presentation/d/1_vhBqdfV9GzhVucIFIZpJ_fZDtikQbWJ/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Java Beans PPT", "https://docs.google.com/presentation/d/1xdVbWwVghNCZmbadAO0xaIJjbybU72K-/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 4", topicsList))


        topicsList = mutableListOf()
        topicsList.add(Topics("Unit 5 PDF", "https://drive.google.com/file/d/1mTsbCeoH_qzpRx3hkCRDswbpwO1kwKfA/view?usp=drive_link"))
        topicsList.add(Topics("JSP PDF", "https://drive.google.com/file/d/1og_LecAerPCVicGzY2k7h4a1DglEc6ng/view?usp=drive_link"))
        topicsList.add(Topics("JSP Introduction PDF", "https://drive.google.com/file/d/1t7nxDHXQZpJzc8URR_anvyJqKDs9yvFA/view?usp=drive_link"))
        topicsList.add(Topics("Implicit Objects in JSP PDF", "https://drive.google.com/file/d/1N72Dw2EdHMgBmxcun-9daaW_sICQElFd/view?usp=drive_link"))
        topicsList.add(Topics("Unit 5 PPT", "https://docs.google.com/presentation/d/1FGmk1h9A1SXT00eGl1Bf59uh7SQ_vdJv/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        topicsList.add(Topics("Servlets PPT", "https://docs.google.com/presentation/d/1js18s8_rWjYPHF4hnni6Gyr_Gra7IGZ_/edit?usp=drive_link&ouid=115747007949407496310&rtpof=true&sd=true"))
        chapterList.add(Chapter("Unit 5", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("JAVA PDF", "https://docs.google.com/presentation/d/1kYtF5QgiUhvClpnnzQvuR398r2qdcULs/edit?usp=drive_link&ouid=106337926642029447298&rtpof=true&sd=true"))
        chapterList.add(Chapter("JAVA", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Imp Questions PDF", "https://drive.google.com/file/d/1RRpiz8Zx6zc36pWMIws50L7OivNjYAI1/view?usp=drive_link"))
        chapterList.add(Chapter("Questions", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("PYQs PDF", "https://drive.google.com/drive/folders/1AE-oIz5mQu0inhdjFw3UHOTg8AXhIzzo?usp=drive_link"))
        chapterList.add(Chapter("PYQs", topicsList))

        topicsList = mutableListOf()
        topicsList.add(Topics("Web Tech Quantum PDF", "https://drive.google.com/file/d/15UgpNW-4qn-4TlLyeCCMFA52SQQ-pUGa/view?usp=drive_link"))
        chapterList.add(Chapter("Web Tech Quantum", topicsList))
        sendData()
    }
    private fun sendData(){
        customAdapter = CustomAdapter(chapterList, this)
        expandableListView.setAdapter(customAdapter)
    }
}
