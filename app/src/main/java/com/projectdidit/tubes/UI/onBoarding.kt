package com.projectdidit.tubes.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView
import com.projectdidit.tubes.Admin.LoginAdmin
import com.projectdidit.tubes.User.HomeUser
import com.projectdidit.tubes.R

class onBoarding : AppCompatActivity() {
    lateinit var login_admin: MaterialCardView
    lateinit var login_user: MaterialCardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        login_admin = findViewById(R.id.login_admin)
        login_admin.setOnClickListener {
            val intent = Intent(this@onBoarding, LoginAdmin::class.java)
            startActivity(intent)
        }

        login_user = findViewById(R.id.login_user)
        login_user.setOnClickListener {
            val intent = Intent(this@onBoarding, HomeUser::class.java)
            startActivity(intent)
        }
    }
}