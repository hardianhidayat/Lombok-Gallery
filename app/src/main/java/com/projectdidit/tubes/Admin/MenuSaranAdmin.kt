package com.projectdidit.tubes.Admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.projectdidit.tubes.Adapter.Saran
import com.projectdidit.tubes.Adapter.SaranAdapter
import com.projectdidit.tubes.R

class MenuSaranAdmin : AppCompatActivity() {
    private lateinit var ref : DatabaseReference
    private lateinit var storage : StorageReference
    private lateinit var firebaseStorage: FirebaseStorage
    private lateinit var rv_list : RecyclerView
    private lateinit var datalist : ArrayList<Saran>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_saran_admin)

        rv_list = findViewById(R.id.rvSaran)
        rv_list.setHasFixedSize(true)
        ref = FirebaseDatabase.getInstance().getReference("Saran")
        rv_list.layoutManager = LinearLayoutManager(this)
        datalist = arrayListOf<Saran>()
        getData()

    }

    private fun getData() {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    datalist.clear()
                    for (userSnapshot in snapshot.children){
                        val saranuser = userSnapshot.getValue(Saran::class.java)
                        datalist.add(saranuser!!)
                    }
                    rv_list.adapter = SaranAdapter(datalist)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("Error", error.message)
            }
        })
    }
}