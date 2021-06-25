package com.projectdidit.tubes.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.R

class menuHib : AppCompatActivity() , View.OnClickListener {
    private lateinit var listMenu: RecyclerView
    private lateinit var mall: CardView
    private lateinit var bioskop: CardView
    private lateinit var waterpark: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_hib)
        mall = findViewById(R.id.btn_mall)
        bioskop = findViewById(R.id.btn_bioskop)
        waterpark = findViewById(R.id.btn_waterpark)


        mall.setOnClickListener(this)
        bioskop.setOnClickListener(this)
        waterpark.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_mall ->{
                val intent = Intent(this@menuHib, ListMallActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_bioskop ->{
                val intent = Intent(this@menuHib, ListBioskopActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_waterpark ->{
                val intent = Intent(this@menuHib, ListWaterparkActivity::class.java)
                startActivity(intent)
            }
        }
    }
}