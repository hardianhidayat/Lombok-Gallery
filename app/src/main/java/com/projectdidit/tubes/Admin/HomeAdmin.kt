package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import com.projectdidit.tubes.*
import com.projectdidit.tubes.UI.onBoarding

class HomeAdmin : AppCompatActivity() {
    lateinit var btn_par_admin: MaterialCardView
    lateinit var btn_bdya_admin: MaterialCardView
    lateinit var btn_hbrn_admin: MaterialCardView
    lateinit var btn_srn_admin: MaterialCardView
    lateinit var btn_logout: MaterialCardView
    private lateinit var auth: FirebaseAuth

    companion object {
        lateinit var admin: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)
        auth = FirebaseAuth.getInstance()
        btn_par_admin = findViewById(R.id.btn_parAdmin)
        btn_par_admin.setOnClickListener {
            val intent = Intent(this@HomeAdmin, MenuParAdmin::class.java)
            startActivity(intent)
        }

        btn_bdya_admin = findViewById(R.id.btn_bdyAdmin)
        btn_bdya_admin.setOnClickListener {
            val intent = Intent(this@HomeAdmin, MenuBudAdmin::class.java)
            startActivity(intent)
        }

        btn_hbrn_admin = findViewById(R.id.btn_hbrAdmin)
        btn_hbrn_admin.setOnClickListener {
            val intent = Intent(this@HomeAdmin, MenuHibAdmin::class.java)
            startActivity(intent)
        }

        btn_srn_admin = findViewById(R.id.btn_srnAdmin)
        btn_srn_admin.setOnClickListener {
            val intent = Intent(this@HomeAdmin, MenuSaranAdmin::class.java)
            startActivity(intent)
        }

        btn_logout = findViewById(R.id.btn_logout)
        btn_logout.setOnClickListener {
            logoutAdmin()
        }
    }

    private fun logoutAdmin() {
        auth.signOut()
        Intent(this@HomeAdmin, onBoarding::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}