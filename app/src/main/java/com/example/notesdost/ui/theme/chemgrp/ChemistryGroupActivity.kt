package com.example.notesdost.ui.theme.chemgrp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.FirstYearMainActivity
import com.example.notesdost.ui.theme.activities.YearSelectionActivity

class ChemistryGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chemistry_group)
        val maths1Card: CardView=findViewById(R.id.maths1Card)
        val maths2Card: CardView=findViewById(R.id.maths2Card)
        val chemistryCard: CardView=findViewById(R.id.chemistryCard)
        val electronicsCard: CardView=findViewById(R.id.electronicsCard)
        val softSkillCard: CardView=findViewById(R.id.softSkillCard)
        val mechanicalCard: CardView=findViewById(R.id.mechanicalCard)
        val electronicsLabCard: CardView=findViewById(R.id.electronicsLabCard)
        val workshopLabCard: CardView=findViewById(R.id.workshopLabCard)
        val chemistryLabCard: CardView=findViewById(R.id.chemistryLabCard)
        val backArrow: ImageView=findViewById(R.id.backArrow)
        val menu: ImageView=findViewById(R.id.menuBar)

        maths1Card.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        maths2Card.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        electronicsCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        softSkillCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        chemistryCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        mechanicalCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }
        backArrow.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, ChemistryGroupActivity::class.java)
            startActivity(intent)
        }


        electronicsLabCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, YearSelectionActivity::class.java)
            startActivity(intent)
        }
        workshopLabCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, YearSelectionActivity::class.java)
            startActivity(intent)
        }
        chemistryLabCard.setOnClickListener{
            val intent = Intent(this@ChemistryGroupActivity, YearSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}


