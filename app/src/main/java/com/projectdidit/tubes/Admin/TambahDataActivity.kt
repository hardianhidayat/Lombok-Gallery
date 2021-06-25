package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.projectdidit.tubes.User.ListPariwisata
import com.projectdidit.tubes.R

class TambahDataActivity : AppCompatActivity() {
    private lateinit var ref : DatabaseReference  //untuk mereferensi data mana yg mau diambil atau uploap
    private lateinit var storage : StorageReference
    private lateinit var firestoreStorage : FirebaseStorage
    private lateinit var et_destinasi : EditText
    private lateinit var et_deskripsi : EditText
    private lateinit var btn_Add : TextView
    private lateinit var id_tujuan : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)

        btn_Add = findViewById(R.id.btn_add)

        et_destinasi = findViewById(R.id.addDestinasi)
        et_deskripsi = findViewById(R.id.addDeskripsi)
        id_tujuan = findViewById(R.id.tujuan)

        firestoreStorage = FirebaseStorage.getInstance()
        storage = firestoreStorage.reference

        btn_Add.setOnClickListener{
            savedata()
            val intent = Intent(this@TambahDataActivity, MenuParAdmin::class.java)
            startActivity(intent)
        }


    }

    private fun savedata() {
        val destinasi = et_destinasi.text.toString().trim()
        val deskripsi = et_deskripsi.text.toString().trim()

        if (destinasi.isEmpty()){
            et_destinasi.error = "Masukan Nama Destinasi"
            return
        }

        if (deskripsi.isEmpty()){
            et_deskripsi.error = "Masukan Deskripsi"
            return
        }

        val tujuan = id_tujuan.text.toString()

        ref = FirebaseDatabase.getInstance().getReference(tujuan) // untuk memasukkan ke tujuan database

        val listPariwisata = ListPariwisata()  // membuat variabel dari data kelas dan akan diisi oleh varibael di atas
        listPariwisata.destinasi = destinasi
        listPariwisata.deskripsi = deskripsi
        saveToFireBase (destinasi, listPariwisata) // menyimpan data
    }

    private fun saveToFireBase (destinasi: String, listPariwisata: ListPariwisata){
        ref.child(destinasi).setValue(listPariwisata).addOnCompleteListener{
            Toast.makeText(applicationContext,"Data Sudah Telah Disimpan", Toast.LENGTH_SHORT).show()
        }
    }

}