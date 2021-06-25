package com.projectdidit.tubes.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.*

class menuPar : AppCompatActivity(), View.OnClickListener {
    private lateinit var listMenu: RecyclerView
    private lateinit var pantai: CardView
    private lateinit var bukit: CardView
    private lateinit var airterjun: CardView
    private lateinit var gili: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_par)
        pantai = findViewById(R.id.btn_pantai)
        bukit = findViewById(R.id.btn_bukit)
        airterjun = findViewById(R.id.btn_airTerjun)
        gili = findViewById(R.id.btn_gili)

        pantai.setOnClickListener(this)
        bukit.setOnClickListener(this)
        airterjun.setOnClickListener(this)
        gili.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_pantai ->{
                val intent = Intent(this@menuPar, ListPantaiActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_bukit ->{
                val intent = Intent(this@menuPar, ListBukitActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_airTerjun ->{
                val intent = Intent(this@menuPar, ListAirTerjunActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_gili ->{
                val intent = Intent(this@menuPar, ListGiliActivity::class.java)
                startActivity(intent)
            }
        }
    }
}