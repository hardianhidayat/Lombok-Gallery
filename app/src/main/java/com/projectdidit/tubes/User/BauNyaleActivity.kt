package com.projectdidit.tubes.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectdidit.tubes.Adapter.AdminAdapter
import com.projectdidit.tubes.R

class BauNyaleActivity : AppCompatActivity() {
    private val list = ArrayList<ListPariwisata>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_air_terjun)

        val rv_baunyale : RecyclerView = findViewById(R.id.rv_listMenu)
        rv_baunyale.setHasFixedSize(true)

        list.addAll(getBauNyake())
        rv_baunyale.layoutManager = LinearLayoutManager(this)
        val BauNyaleAdapter = (list)

        rv_baunyale.adapter = AdminAdapter(list)
    }

    private fun getBauNyake(): Collection<ListPariwisata> {
        val name = resources.getStringArray(R.array.data_name)
        val desc = resources.getStringArray(R.array.data_desc)


        val baunyale = ArrayList<ListPariwisata>()
        for (i in name.indices) {
            val listMenu = ListPariwisata(
                name[i],
                desc[i]
            )
            baunyale.add(listMenu)
        }
        return baunyale

    }
}