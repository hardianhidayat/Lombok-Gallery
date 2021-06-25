package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.R

class MenuHibAdmin : AppCompatActivity() {
    private lateinit var listMenu: RecyclerView
    private lateinit var mallAdmin: CardView
    private lateinit var bioskopAdmin: CardView
    private lateinit var waterparkAdmin: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_hib_admin)

        mallAdmin = findViewById(R.id.btn_mall_admin)
        bioskopAdmin = findViewById(R.id.btn_bioskop_admin)
        waterparkAdmin = findViewById(R.id.btn_waterpark_admin)

        mallAdmin.setOnClickListener{
            val intent = Intent(this@MenuHibAdmin, ListMallAdmin::class.java)
            startActivity(intent)
        }
        bioskopAdmin.setOnClickListener{
            val intent = Intent(this@MenuHibAdmin, ListBioskopAdmin::class.java)
            startActivity(intent)
        }
        waterparkAdmin.setOnClickListener{
            val intent = Intent(this@MenuHibAdmin, ListWaterparkAdmin::class.java)
            startActivity(intent)
        }
    }
}