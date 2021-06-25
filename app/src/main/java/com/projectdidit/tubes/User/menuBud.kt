package com.projectdidit.tubes.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.*

class menuBud : AppCompatActivity(), View.OnClickListener {
    private lateinit var listMenu: RecyclerView
    private lateinit var nyongkolan : CardView
    private lateinit var presean: CardView
    private lateinit var bauNyale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bud)

        nyongkolan = findViewById(R.id.btn_nyongkolan)
        presean = findViewById(R.id.btn_presean)
        bauNyale = findViewById(R.id.btn_bauNyale)

        nyongkolan.setOnClickListener(this)
        presean.setOnClickListener(this)
        bauNyale.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_nyongkolan ->{
                val intent = Intent(this@menuBud, ListNyongkolanActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_presean ->{
                val intent = Intent(this@menuBud, ListPreseanActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_bauNyale ->{
                val intent = Intent(this@menuBud, ListBauNyaleActivity::class.java)
                startActivity(intent)
            }
        }
    }

}

