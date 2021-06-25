package com.projectdidit.tubes.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.projectdidit.tubes.R

class LoginAdmin : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var Login: TextView
    private lateinit var auth: FirebaseAuth

    companion object {
        lateinit var admin: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)

        Login = findViewById(R.id.tv_login)
        Login.setOnClickListener(this)
        auth = FirebaseAuth.getInstance()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_login -> {
                etUsername = findViewById(R.id.et_username)
                etPassword = findViewById(R.id.et_password)
                val username = etUsername.text.toString().trim()
                val password = etPassword.text.toString().trim()

                if (username.isEmpty()) {
                    etUsername.error = "Silahkan Isi Username Anda"
                    etUsername.requestFocus()
                    return
                }

                if (password.isEmpty()) {
                    etPassword.error = "Silahkan Isi Password Anda"
                    etPassword.requestFocus()
                    return
                }
                loginAdmin(username, password)
            }
        }
    }

    private fun loginAdmin(username: String, password: String) {
        auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        admin = auth
                        Intent(this@LoginAdmin, HomeAdmin::class.java).also {
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            admin = auth
            Intent(this@LoginAdmin, HomeAdmin::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}