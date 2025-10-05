package com.example.notesdost.ui.theme.activities.others

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.google.android.material.button.MaterialButton

class MiscActivities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misc)

        val notesCard: CardView = findViewById(R.id.notesCard)
        val quizCard: CardView = findViewById(R.id.quizCard)
        val wifiCard: CardView = findViewById(R.id.wifiCard)
        val attendanceCard: CardView = findViewById(R.id.attendanceCard)

        notesCard.setOnClickListener {
            val intent = Intent(this@MiscActivities, YearSelectionActivity::class.java)
            startActivity(intent)
        }

        quizCard.setOnClickListener {
            val intent = Intent(this@MiscActivities, Quiz::class.java)
            startActivity(intent)
        }

        wifiCard.setOnClickListener {
            val intent = Intent(this@MiscActivities, WifiActivity::class.java)
            startActivity(intent)
        }

        attendanceCard.setOnClickListener {
            val dialogBox = Dialog(this)
            dialogBox.setContentView(R.layout.dialog_box)
            dialogBox.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialogBox.window?.setBackgroundDrawableResource(R.drawable.dialog_bg)

            val buttonAIMS: Button = dialogBox.findViewById(R.id.aimsButton)
            val buttonCal: Button = dialogBox.findViewById(R.id.calculatorButton)

            buttonAIMS.setOnClickListener {
                dialogBox.dismiss()
                val intent = Intent(this@MiscActivities, Attendance::class.java)
                startActivity(intent)
            }

            buttonCal.setOnClickListener {
                dialogBox.dismiss()
                val intent = Intent(this@MiscActivities, Calculator::class.java)
                startActivity(intent)
            }

            // Show the dialog
            dialogBox.show() // Ensure this line is present
        }

        val feedbackImg: ImageView = findViewById(R.id.feedbackImg)
        feedbackImg.setOnClickListener {
            val intent = Intent(this@MiscActivities, Feedback::class.java)
            startActivity(intent)
        }

        val menu: ImageView = findViewById(R.id.menuBar)
        menu.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.main_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.privacy -> {
                    startActivity(Intent(this@MiscActivities, Privacy::class.java))
                    true
                }
                R.id.about -> {
                    startActivity(Intent(this@MiscActivities, About::class.java))
                    true
                }
                R.id.feedback -> {
                    startActivity(Intent(this@MiscActivities, Feedback::class.java))
                    true
                }
                R.id.quiz -> {
                    startActivity(Intent(this@MiscActivities, Quiz::class.java))
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.privacy -> {
                startActivity(Intent(this, Privacy::class.java))
                true
            }
            R.id.about -> {
                startActivity(Intent(this, About::class.java))
                true
            }
            R.id.feedback -> {
                startActivity(Intent(this, Feedback::class.java))
                true
            }
            R.id.quiz -> {
                startActivity(Intent(this, Quiz::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
