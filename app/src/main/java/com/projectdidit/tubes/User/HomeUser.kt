package com.projectdidit.tubes.User

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.projectdidit.tubes.R


class HomeUser : AppCompatActivity() {

    lateinit var btn_par:MaterialCardView
    lateinit var btn_bdya:MaterialCardView
    lateinit var btn_hbrn:MaterialCardView
    lateinit var btn_saran:MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_user)

        btn_par=findViewById(R.id.btn_pari)
        btn_par.setOnClickListener {
            val intent = Intent(this@HomeUser, menuPar::class.java)
            startActivity(intent)
        }

        btn_bdya=findViewById(R.id.btn_bdy)
        btn_bdya.setOnClickListener {
            val intent = Intent(this@HomeUser, menuBud::class.java)
            startActivity(intent)
        }

        btn_hbrn=findViewById(R.id.btn_hbr)
        btn_hbrn.setOnClickListener {
            val intent = Intent(this@HomeUser, menuHib::class.java)
            startActivity(intent)
        }

        btn_saran=findViewById(R.id.btn_srn)
        btn_saran.setOnClickListener {
            val intent = Intent(this@HomeUser, menuSaran::class.java)
            startActivity(intent)
        }
    }
}