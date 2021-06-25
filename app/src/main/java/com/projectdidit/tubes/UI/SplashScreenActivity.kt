package com.projectdidit.tubes.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.projectdidit.tubes.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()

        handler.postDelayed({
            val intent = Intent(this, onBoarding::class.java)
            startActivity(intent)
            finishAffinity()
        }, 3000)
    }
}