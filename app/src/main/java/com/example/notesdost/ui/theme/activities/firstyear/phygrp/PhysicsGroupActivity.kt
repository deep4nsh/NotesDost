package com.example.notesdost.ui.theme.activities.firstyear.phygrp

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.others.About
import com.example.notesdost.ui.theme.activities.others.Privacy

class PhysicsGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_group)
        val maths1Card: CardView=findViewById(R.id.maths1Card)
        val maths2Card: CardView=findViewById(R.id.maths2Card)
        val physicsCard: CardView=findViewById(R.id.physicsCard)
        val electricalCard: CardView=findViewById(R.id.electricalCard)
        val evsCard: CardView=findViewById(R.id.evsCard)
        val ppsCard: CardView=findViewById(R.id.ppsCard)
        val electricalLabCard: CardView=findViewById(R.id.electricalLabCard)
        val graphicsLabCard: CardView=findViewById(R.id.graphicsLabCard)
        val ppsLabCard: CardView=findViewById(R.id.ppsLabCard)
        val physicsLabCard: CardView=findViewById(R.id.physicsLabCard)

        maths1Card.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpMaths1::class.java)
            startActivity(intent)
        }
        maths2Card.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpMaths2::class.java)
            startActivity(intent)
        }
        electricalCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpElectrical::class.java)
            startActivity(intent)
        }
        evsCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpEVS::class.java)
            startActivity(intent)
        }
        physicsCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpPhysics::class.java)
            startActivity(intent)
        }
        ppsCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpPPS::class.java)
            startActivity(intent)
        }

        ppsLabCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpPPSLab::class.java)
            startActivity(intent)
        }
        electricalLabCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpElecLab::class.java)
            startActivity(intent)
        }
        graphicsLabCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpGraphicsLab::class.java)
            startActivity(intent)
        }
        physicsLabCard.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, PhyGrpPhyLab::class.java)
            startActivity(intent)
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
                    val intent = Intent(this@PhysicsGroupActivity, Privacy::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about -> {
                    // Open About Activity
                    val intent = Intent(this@PhysicsGroupActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feedback -> {
                    // Open About Activity
                    val intent = Intent(this@PhysicsGroupActivity, About::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

}
