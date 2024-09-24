package com.example.notesdost.ui.theme.activities.others

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.firstyear.FirstYearMainActivity
import com.example.notesdost.ui.theme.activities.secondyear.SecondYearMainActivity

class YearSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_year_selection)

        val firstYearCard: CardView = findViewById(R.id.firstYear)
        val secondYearCard: CardView = findViewById(R.id.secondYear)
        val thirdYearCard: CardView = findViewById(R.id.thirdYear)
        val fourthYearCard: CardView = findViewById(R.id.fourthYear)
        val firstYearMCACard: CardView = findViewById(R.id.firstYearMCA)
        val secondYearMCACard: CardView = findViewById(R.id.secondYearMCA)


        firstYearCard.setOnClickListener {
            val intent = Intent(this@YearSelectionActivity, FirstYearMainActivity::class.java)
            startActivity(intent)
        }
        secondYearCard.setOnClickListener {
            val intent = Intent(this@YearSelectionActivity, SecondYearMainActivity::class.java)
            startActivity(intent)
        }
        thirdYearCard.setOnClickListener {
            val intent = Intent(this@YearSelectionActivity, ThirdYearMainActivity::class.java)
            startActivity(intent)
        }
        fourthYearCard.setOnClickListener {
            val intent = Intent(this@YearSelectionActivity, FourthYearMainActivity::class.java)
            startActivity(intent)
        }
        firstYearMCACard.setOnClickListener {
            val intent = Intent(this@YearSelectionActivity, SplashActivity::class.java)
            startActivity(intent)
        }
        secondYearMCACard.setOnClickListener {
            val intent = Intent(this@YearSelectionActivity, SplashActivity::class.java)
            startActivity(intent)
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
                    val intent = Intent(this@YearSelectionActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@YearSelectionActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    // This creates the options menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Handle menu item selection
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
            else -> super.onOptionsItemSelected(item)
        }
    }
}
