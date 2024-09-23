package com.example.notesdost.ui.theme.phygrp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.notesdost.R
import com.example.notesdost.ui.theme.activities.FirstYearMainActivity

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
        val backArrow: ImageView=findViewById(R.id.backArrow)
        val menu: ImageView=findViewById(R.id.menuBar)

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
        backArrow.setOnClickListener{
            val intent = Intent(this@PhysicsGroupActivity, FirstYearMainActivity::class.java)
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
    }
}
