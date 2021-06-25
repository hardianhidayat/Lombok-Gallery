package com.projectdidit.tubes.User

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.projectdidit.tubes.Adapter.Saran
import com.projectdidit.tubes.R


class FragmentSaran : Fragment() {

    private lateinit var ref : DatabaseReference
    private lateinit var storage : StorageReference
    private lateinit var firestoreStorage : FirebaseStorage
    private lateinit var etSaran : EditText
    private lateinit var btnSaran : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etSaran = view.findViewById(R.id.isi_saran)
        btnSaran = view.findViewById(R.id.btn_saran)

        firestoreStorage = FirebaseStorage.getInstance()
        storage = firestoreStorage.reference

        btnSaran.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val textsaran = etSaran.text.toString().trim()
        if (textsaran.isEmpty()){
            etSaran.error = "Masukan Nama Destinasi"
            return
        }
        ref = FirebaseDatabase.getInstance().getReference("Saran")
        val saran = Saran()
        saran.saranUser = textsaran
        saveToFireBase (textsaran, saran)

    }

    private fun saveToFireBase(textsaran: String, saran: Saran) {
        ref.child(textsaran).setValue(saran).addOnCompleteListener{
            Toast.makeText(activity,"Data Sudah Telah Disimpan", Toast.LENGTH_SHORT).show()
        }

    }
}