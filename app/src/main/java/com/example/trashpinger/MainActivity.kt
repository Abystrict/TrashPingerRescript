package com.example.trashpinger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginbuttonconfigure()
        }
    private fun loginbuttonconfigure() {
        val buttonlogin:Button = findViewById(R.id.loginbutton)
        buttonlogin.setOnClickListener{
            val WelcomeScreenSwitcher = Intent(this, MainActivity2::class.java)
            startActivity(WelcomeScreenSwitcher)
        }
    }
}
