package com.example.notesdost.ui.theme.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.chemgrp.ChemistryGroupActivity
import com.example.notesdost.ui.theme.phygrp.PhysicsGroupActivity

class FirstYearMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_year_main)

        val physicsGroupCard:CardView=findViewById(R.id.physicsGroupCard)
        val chemistryGroupCard: CardView=findViewById(R.id.chemistryGroupCard)
        val backArrow: ImageView = findViewById(R.id.backArrow)
        val menuBar: ImageView = findViewById(R.id.menuBar)
        backArrow.setOnClickListener {
            val intent = Intent(this@FirstYearMainActivity, SplashActivity::class.java)
            startActivity(intent)
        }
        menuBar.setOnClickListener {
            val intent = Intent(this@FirstYearMainActivity, SplashActivity::class.java)
            startActivity(intent)
        }
        physicsGroupCard.setOnClickListener{
            val intent=Intent(this@FirstYearMainActivity, PhysicsGroupActivity::class.java)
            startActivity(intent)
        }
        chemistryGroupCard.setOnClickListener{
            val intent=Intent(this@FirstYearMainActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
    }
}