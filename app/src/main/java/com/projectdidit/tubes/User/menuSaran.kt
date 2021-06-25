package com.projectdidit.tubes.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.projectdidit.tubes.R

class menuSaran : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_saran)

        val fragmentsaran = FragmentSaran()
        val fragment = supportFragmentManager.findFragmentByTag(FragmentSaran::class.java.simpleName) //

        if (fragment !is FragmentSaran) {
            supportFragmentManager.beginTransaction()
                .add(R.id.saran, fragmentsaran, FragmentSaran::class.java.simpleName)
                .commit()
        }
    }
}