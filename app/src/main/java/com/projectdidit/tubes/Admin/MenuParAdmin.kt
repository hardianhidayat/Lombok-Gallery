package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.*

class MenuParAdmin : AppCompatActivity() {
    private lateinit var listMenu: RecyclerView
    private lateinit var pantaiAdmin: CardView
    private lateinit var bukitAdmin: CardView
    private lateinit var airterjunAdmin: CardView
    private lateinit var giliAdmin: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_par_admin)
        pantaiAdmin = findViewById(R.id.btn_pantaiAdmin)
        bukitAdmin = findViewById(R.id.btn_bukitAdmin)
        airterjunAdmin = findViewById(R.id.btn_airTerjunAdmin)
        giliAdmin = findViewById(R.id.btn_giliAdmin)

        pantaiAdmin.setOnClickListener{
            val intent = Intent(this@MenuParAdmin, ListPantaiAdmin::class.java)
            startActivity(intent)
        }
        bukitAdmin.setOnClickListener{
            val intent = Intent(this@MenuParAdmin, ListBukitAdmin::class.java)
            startActivity(intent)
        }
        airterjunAdmin.setOnClickListener{
            val intent = Intent(this@MenuParAdmin, ListAirTerjunAdmin::class.java)
            startActivity(intent)
        }
        giliAdmin.setOnClickListener{
            val intent = Intent(this@MenuParAdmin, ListGliAdmin::class.java)
            startActivity(intent)
        }
    }
}