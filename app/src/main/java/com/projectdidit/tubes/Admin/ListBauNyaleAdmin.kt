package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.projectdidit.tubes.Adapter.AdminAdapter
import com.projectdidit.tubes.User.ListPariwisata
import com.projectdidit.tubes.R

class ListBauNyaleAdmin : AppCompatActivity() {
    private lateinit var btn_Tambah: Button
    private lateinit var ref: DatabaseReference
    private lateinit var storage: StorageReference
    private lateinit var firebaseStorage: FirebaseStorage
    private lateinit var rv_list: RecyclerView
    private lateinit var datalist: ArrayList<ListPariwisata>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_list_bau_nyale_admin)
            btn_Tambah = findViewById(R.id.btn_tambah_bau_nyale)
            btn_Tambah.setOnClickListener {
                val intent = Intent(this@ListBauNyaleAdmin, TambahDataActivity::class.java)
                startActivity(intent)
            }
            rv_list = findViewById(R.id.rvAdmin)
            rv_list.setHasFixedSize(true)
            ref = FirebaseDatabase.getInstance().getReference("Bau Nyale")
            rv_list.layoutManager = LinearLayoutManager(this)


            datalist = arrayListOf<ListPariwisata>()
            getData()
        }

        private fun getData() {
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        datalist.clear()
                        for (userSnapshot in snapshot.children) {
                            val wst = userSnapshot.getValue(ListPariwisata::class.java)

                            datalist.add(wst!!)
                        }
                        rv_list.adapter = AdminAdapter(datalist)
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    Log.e("PantaiFragment", error.message)
                }
            })
        }
    }
