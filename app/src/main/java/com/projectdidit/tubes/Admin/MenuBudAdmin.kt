package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.R

class MenuBudAdmin : AppCompatActivity() {
    private lateinit var listMenu: RecyclerView
    private lateinit var nyongkolanAdmin: CardView
    private lateinit var baunyaleAdmin: CardView
    private lateinit var preseanAdmin: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bud_admin)

        nyongkolanAdmin = findViewById(R.id.btn_nyongkolan_admin)
        baunyaleAdmin = findViewById(R.id.btn_bauNyale_admin)
        preseanAdmin = findViewById(R.id.btn_presean_admin)

        nyongkolanAdmin.setOnClickListener{
            val intent = Intent(this@MenuBudAdmin, ListNyongkolanAdmin::class.java)
            startActivity(intent)
        }
        baunyaleAdmin.setOnClickListener{
            val intent = Intent(this@MenuBudAdmin, ListBauNyaleAdmin::class.java)
            startActivity(intent)
        }
        preseanAdmin.setOnClickListener{
            val intent = Intent(this@MenuBudAdmin, ListPreseanAdmin::class.java)
            startActivity(intent)
        }
    }
}