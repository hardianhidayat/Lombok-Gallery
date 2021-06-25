package com.projectdidit.tubes.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.projectdidit.tubes.Adapter.UserAdapter
import com.projectdidit.tubes.R

class ListMallActivity : AppCompatActivity() {
    private lateinit var btn_Tambah : Button
    private lateinit var ref : DatabaseReference
    private lateinit var storage : StorageReference
    private lateinit var firebaseStorage: FirebaseStorage
    private lateinit var rv_list : RecyclerView
    private lateinit var datalist : ArrayList<ListPariwisata>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_mall)

        rv_list = findViewById(R.id.rv_listMenu)
        rv_list.setHasFixedSize(true)
        ref = FirebaseDatabase.getInstance().getReference("Mall")
        rv_list.layoutManager = LinearLayoutManager(this)

        datalist = arrayListOf<ListPariwisata>()
        getData()

    }
    private fun getData() {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    datalist.clear()
                    for (userSnapshot in snapshot.children){
                        val wst = userSnapshot.getValue(ListPariwisata::class.java)

                        datalist.add(wst!!)
                    }
                    rv_list.adapter = UserAdapter(datalist)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("PantaiFragment", error.message)
            }

        })
    }
}